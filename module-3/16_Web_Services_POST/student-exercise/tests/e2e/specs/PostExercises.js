describe("Web API (POST) Exercises", () => {

  describe('CRUD Topics', () => {

    it('should list all topics', () => {
      cy.visit('/')
      cy.contains('luctus et');
      cy.get('.topic-list tbody tr').should('have.length', 20);
    })

    it('Step Two Tests: should create new topic', () => {
      cy.visit('/add-topic')
      cy.get('input').type('This is a TEST title for a new topic');
      cy.get('button').click();
      cy.contains('This is a TEST title for a new topic');
      cy.get('.topic-list tbody tr').should('have.length', 21);
    });

    it('Step Three Tests: should edit the new topic', () => {
      cy.visit('/');
      // find the new topic and edit it
      cy.contains('This is a TEST title for a new topic').then(($link) => {
        cy.visit(`/edit-topic${$link.attr("href")}`);
        cy.get('input').clear().type('Updated TEST title');
        cy.get('button').click();
        cy.contains('Updated TEST title');
      })
    });

    it('Step Four Tests: should delete the new topic', () => {
      cy.visit('/');
      cy.contains('Updated TEST title');
      cy.get('tbody tr a').last().click();
      cy.get('.topic-list tbody tr').should('have.length', 20);
    })

  })

  describe('CRUD Messages', () => {

    it('should list all messages for topic adipiscing molestie hendrerit', () => {
      cy.contains('adipiscing molestie hendrerit').click();
      cy.get('.topic-message').should('have.length', 4);
    })

    it('Step Five Tests: should create new message', () => {
      cy.visit('/1/add-message')
      cy.get('input[name="title"]').type('TEST TITLE');
      cy.get('input[name="messageText"]').type('TEST MESSAGE TEXT');
      cy.get('button').click();
      cy.contains('TEST TITLE');
      cy.contains('TEST MESSAGE TEXT')
      cy.get('.topic-message').should('have.length', 5);
    });

    it('Step Six Tests: should edit the new message', () => {
      cy.visit('/1');
      cy.get('.btnEditMessage').last().click();
      cy.get('input[name="title"]').clear().type('UPDATED TEST TITLE');
      cy.get('input[name="messageText"]').clear().type('UPDATED TEST MESSAGE TEXT');
      cy.get('button').click();
      cy.contains('UPDATED TEST TITLE');
      cy.contains('UPDATED TEST MESSAGE TEXT')
    });

    it('Step Seven Tests: should delete the new message', () => {
      cy.visit('/1');
      cy.contains('UPDATED TEST TITLE');
      cy.contains('UPDATED TEST MESSAGE TEXT');
      cy.get('.btnDeleteMessage').last().click();
      cy.get('.topic-message').should('have.length', 4);
    })

  });

});

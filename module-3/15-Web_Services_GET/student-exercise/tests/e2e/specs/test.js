// https://docs.cypress.io/api/introduction/api.html

describe('Web API (GET) Exercises', () => {
  describe('Step Three Tests', () => {
    it('should show topics on /', () => {
      cy.visit('/');
      cy.get('.topic').should('have.length', 20);
    });
    it('should properly show topic titles', () => {
        cy.visit('/');
        cy.contains('luctus et');
    });
  });

  describe('Step Four Tests', () => {
    it('should link topic to details', () => {
      cy.visit('/');
      cy.contains('a[href$="/13"]', "luctus et");
    });
    it('should show details on detail page', () => {
      cy.visit('/13');
      cy.contains('h1', 'luctus et');
      cy.contains('h3.message-title', 'mauris eget');
      cy.contains('.message-body', 'tortor duis');
      cy.contains('h3.message-title', 'nibh fusce');
      cy.contains('.message-body', 'libero convallis');
      cy.contains('h3.message-title', 'neque libero');
      cy.contains('.message-body', 'ipsum dolor sit amet');
      cy.contains('h3.message-title', 'tempus vel pede');
      cy.contains('.message-body', 'eget eros elementum');
    });
    it('should show all messages in a topic', () => {
      cy.visit('/17');
      cy.get('h3.message-title').should('have.length', 4);
    });
  });
});

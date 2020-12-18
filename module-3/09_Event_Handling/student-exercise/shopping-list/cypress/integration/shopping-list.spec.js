describe('Shopping List Events Exercise Tests', () => {
  it('parent container shopping-list should exist', () => {
    cy.visit('/');
    cy.get('.shopping-list').should('exist');
  });

  it('should have a title of My Shopping List', () => {
    cy.get('h1').should('contain', 'My Shopping List');
  });

  it('should have 10 items on the shopping list', () => {
    cy.get('li').should('have.length', 10);
  });

  it('each item in the list should not have the class completed until it has been clicked on', () => {
    cy.get('li').each(($item) => {
      cy.wrap($item).should('not.have.class', 'completed');
      cy.wrap($item).click();
      cy.wrap($item).should('have.class', 'completed');
    });
  });

  it('each item in the list that is completed can be double clicked on and marked incomplete', () => {
    cy.get('li').each(($item) => {
      cy.wrap($item).should('have.class', 'completed');
      cy.wrap($item).dblclick();
      cy.wrap($item).should('not.have.class', 'completed');
    });
  });

  it('clicking on the mark all completed button should set all items to completed', () => {
    cy.get('#toggleAll').click();
    cy.get('li').each(($item) => {
      cy.wrap($item).should('have.class', 'completed');
    });
    cy.get('#toggleAll').should('contain', 'Mark All Incomplete');
  });

  it('clicking on the mark all incomplete button should set all items to incomplete', () => {
    cy.get('#toggleAll').click();
    cy.get('li').each(($item) => {
      cy.wrap($item).should('not.have.class', 'completed');
    });
    cy.get('#toggleAll').should('contain', 'Mark All Complete');
  });
});

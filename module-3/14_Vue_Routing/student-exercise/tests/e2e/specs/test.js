// https://docs.cypress.io/api/introduction/api.html

describe('Routing Exercise', () => {

  describe('Step One Tests', () => {
    it('should show the best sellers at /', () => {
      cy.visit('/');
      cy.get('.best-seller-list');
    });

    it('should show the new releases at /', () => {
      cy.visit('/');
      cy.get('.new-releases-list');
    });
  });

  describe('Step Two Tests', () => {
    it('should show the reading list at /myBooks', () => {
      cy.visit('/myBooks');
      cy.get('.book-container');
    });
  });

  describe("Step Three Tests", () => {
    it('should have navigation in the App component for home', () => {
      cy.visit('/');
      cy.get('a[href$="/"]');
    });
    it('should have navigation in the App component for my books', () => {
      cy.visit('/');
      cy.get('a[href$="/myBooks"');
    });
  });

  describe("Step Four Tests", () => {
    it('should show the new book form at /addBook', () => {
      cy.visit('/addBook');
      cy.get('.new-book-form');
    });
  });

  describe("Step Five Tests", () => {
    it('should show a link to /addBook on the My Books page', () => {
      cy.visit('/myBooks');
      cy.get('a[href$="/addBook"]');
    });
    it('should go back to myBooks when a new book is submitted', () => {
      cy.visit('/addBook');
      cy.get('.title-input').type('TEST');
      cy.get('.author-input').type('TEST');
      cy.get('.isbn-input').type('1111111111');
      cy.get('.new-book-form button').click();

      cy.url().should('include', '/myBooks');
    });
  });

  describe("Step Six Tests", () => {
    it('should show book details when loading book page', () => {
      cy.visit('/book/9781400079278');
      cy.contains('Kafka by the Shore');
      cy.contains('Haruki Murakami');
    });
    it('should link to book page from reading list cards', () => {
      cy.visit('/myBooks');
      cy.get('a[href$="/book/9781400079278"]');
      cy.get('a[href$="/book/9780356500157"]');
      cy.get('a[href$="/book/9780684830490"]');
      cy.get('a[href$="/book/9783125971400"]');
    });
  });
});

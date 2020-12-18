// https://docs.cypress.io/api/introduction/api.html

describe('Component Communication Exercise', () => {
  beforeEach(() => {
    cy.visit('/');
  })

  describe('Step One Tests', () => {
    it('should load the app on root url', () => {
      cy.contains('h1', 'Reading List');
    });

    it('should show divs for all book data', () => {
      cy.get(".card").should('have.length', 4);
    });
  });

  describe('Step Two Tests', () => {
    it('should show all hard coded data for books', () => {
      cy.contains(".book-title", "Kafka on the Shore");
      cy.contains(".book-title", "The Girl With All the Gifts");
      cy.contains(".book-title", "The Old Man and the Sea");
      cy.contains(".book-title", "Le Petit Prince");
      cy.contains(".book-author", "Haruki Murakami");
      cy.contains(".book-author", "M.R. Carey");
      cy.contains(".book-author", "Ernest Hemingway");
      cy.contains(".book-author", "Antoine de Saint-Exupéry");
      cy.get("img").as('images');
      cy.get("@images").should('have.length', 4);
      cy.get("@images").eq(0)
        .should("have.attr", "src")
        .and("include", "9781400079278");
      cy.get("@images").eq(1)
        .should("have.attr", "src")
        .and("include", "9780356500157");
      cy.get("@images").eq(2)
        .should("have.attr", "src")
        .and("include", "9780684830490");
      cy.get("@images").eq(3)
        .should("have.attr", "src")
        .and("include", "9783125971400");
    });
  });

  describe("Step Three Tests", () => {
    it('should mark book as read when "Mark Read" button is pressed', () => {
      cy.get(".card:has(> .mark-read)")
        .first()
        .as("card");
      cy.get("@card")
        .find(".mark-read")
        .click();
      cy.get("@card")
        .find(".mark-read")
        .should("not.exist");
      cy.get("@card").find(".mark-unread");
    });

    it('should mark book as unread when "Mark Unread" button is pressed', () => {
      cy.get(".card:has(> .mark-unread)")
        .first()
        .as("card");
      cy.get("@card")
        .find(".mark-unread")
        .click();
      cy.get("@card")
        .find(".mark-unread")
        .should("not.exist");
      cy.get("@card").find(".mark-read");
    });
  });

  describe("Step Four Tests", () => {
    it("should add a new card when a book is added in the form", () => {
      cy.get(".title-input").type("TEST BOOK");
      cy.get(".author-input").type("TEST AUTHOR");
      cy.get(".isbn-input").type("1111111111{enter}");

      cy.get(".card")
        .last()
        .as("card");

      cy.get("@card").find(".book-title", "TEST BOOK");
      cy.get("@card").find(".book-author", "TEST AUTHOR");
      cy.get("@card")
        .find("img")
        .should("have.attr", "src")
        .and("include", "1111111111");
      cy.get("@card")
        .find("button")
        .should("have.class", "mark-read");
    });
  });
});

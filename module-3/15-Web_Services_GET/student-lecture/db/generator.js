module.exports = function() {
  var faker = require("faker");
  var _ = require("lodash");
  var moment = require("moment");

  function getBackgroundColor(index) {
    let bg = "";
    switch(index) {
      case 1:
        bg = "#1bb698";
        break;
      case 2:
        bg = "#fb826f";
        break;
      case 3:
        bg = "#35284f";
        break;
    }
    return bg;
  }

  return {
    boards: _.times(3, function(n) {
      const date = moment(faker.date.recent());
      return {
        id: faker.random.number(),
        title: faker.random.words(2),
        backgroundColor: getBackgroundColor(n+1),
        cards:
          _.times(15, function(x) {
            return  {
              id: faker.random.number(),
              title: faker.random.words(3),
              description: faker.lorem.paragraph(),
              avatar: faker.image.avatar(),
              date: date.format('MMM Do YYYY'),
              status: _.sample(["Planned", "In Progress", "Completed"]),
              tag: _.sample(["Feature Request", "Design", "Q&A"]),
              comments:
                _.times(4, function(y) {
                  return {
                    id: faker.random.number(),
                    author: faker.name.firstName() + ' ' + faker.name.lastName(),
                    body: faker.lorem.paragraphs(3),
                    postedOn: date.format('MMMM Do YYYY, h:mm:ss a')
                  }
                })
            }
          })
      };
    })
  };

};

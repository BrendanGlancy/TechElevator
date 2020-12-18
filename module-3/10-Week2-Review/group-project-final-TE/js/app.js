const PROBLEMS_PER_SET = 10;
let problemSet = [];
let currentProblem = 1;
let score = 0;

/*
 * Generates a problem set with {PROBLEMS_PER_SET} problems
 *
 */
function generateProblemSet() {
  for(i = 0; i < PROBLEMS_PER_SET; ++i) {
    const problem = {
      left: getRandomNumber(10),
      right: getRandomNumber(10),
      answer: null
    }
    const correctAnswer = problem.left * problem.right;
    problem.answer = correctAnswer;
    const answers = shuffleArray([correctAnswer,getRandomNumber(82),getRandomNumber(82),getRandomNumber(82)]);
    problemSet.push({ problem, answers });
  }
}


/**
 * Handles display the current problem set
 * The expression & answers are both empty by default
 */
function displayProblemSet() {
  displayProblem();
  displayAnswers();
}

/**
 * Sets the current problem (expression) based on the currentProblem
 *
 */
function displayProblem() {
  const pContainer = document.getElementById('problem');
  const expression = `${problemSet[currentProblem-1].problem.left} * ${problemSet[currentProblem-1].problem.right}`;
  pContainer.querySelector('div.expression').innerText = expression;
}

/**
 * Displays the 4 possible answers for the current problem
 */
function displayAnswers() {
  const aContainer = document.getElementById('answers');
  const list = aContainer.querySelector('ul');
  const listItems = list.querySelectorAll('li');
  const answers = problemSet[currentProblem - 1].answers;

  for(i = 0; i < answers.length; ++i) {
    listItems[i].innerText = answers[i];
  }

}

/**
 * Move to the next problem in the set
 * If there are no more problems hide the expression and answers to indicate that
 * we are done with the problem set.
 */
function nextProblem() {
  // only move to the next problem is there are more problems to display
  if( currentProblem <  PROBLEMS_PER_SET ) {
    updateCurrentProblem();
    displayProblem();
    displayAnswers();
  } else {
    toggleShowHide();
  }
}

/**
 * Increments the current problem by 1 and sets the new problem expression
 */
function updateCurrentProblem() {
  currentProblem += 1;
  // the current problem was already update, change the display
  document.querySelector('.currentProblem').innerText = currentProblem;
}

/**
 * Increments the current problem by 1 and updates the current score
 */
function updateScore() {
  score += 1;
  // the score was already updated if it needed to be, change the display
  document.querySelector('.currentScore').innerText = score;
}

/**
 * Clears the score back to 0
 */
function clearScore() {
  document.querySelector('.currentScore').innerText = 0;
}

/**
 * When a problem set is complete any class with showHide should be hidden
 * When you start a new problem set any class with showHide should be visible
 */
function toggleShowHide() {
  const elements = document.querySelectorAll('.show-hide');
  elements.forEach((element) => {
    element.classList.toggle("hidden", currentProblem == PROBLEMS_PER_SET );
  });
}

/**
 * Utility function to generate a random number based on max
 * @param {number} max
 */
function getRandomNumber(max) {
  return Math.floor(Math.random() * Math.floor(max));
}

/**
 * Utility function to shuffle the items in an array
 * @param {object} arr
 */
function shuffleArray(arr) {
  return arr.sort(function (a, b) { return Math.random() - 0.5 })
}

/**
 * Starts a new application by
 * - generating a new problem set
 * - starts the display of a problem set by displaying the first problem.
 */
function startNewProblemSet() {
  // we are working through an existing problem set
  if( currentProblem > 1 ) {
    problemSet = [];
    currentProblem = 0;
    score = 0;
    toggleShowHide();
    updateCurrentProblem();
    clearScore();
  }

  generateProblemSet();
  displayProblemSet();
}


/**
 * When the DOM has been loaded attach event listeners and start a new problem set
 */
document.addEventListener("DOMContentLoaded",() => {

  let answerListItems = document.querySelectorAll('#answers ul li');
  answerListItems.forEach( (element) => {
      element.addEventListener('click', (e) => {
        const answer = parseInt(e.currentTarget.innerText);
        const currentAnswer = parseInt(problemSet[currentProblem-1].problem.answer);
        if( answer == currentAnswer ) {
          updateScore();
        }
        nextProblem();
      });
  });

  document.getElementById('btnStartOver').addEventListener('click',() => {
    startNewProblemSet();
  })

  startNewProblemSet();
});






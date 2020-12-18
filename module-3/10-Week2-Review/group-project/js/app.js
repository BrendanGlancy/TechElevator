/**
 * Steps in solving the problem
 * 
 * Randomly generate the problem / create the problem set
 *  generate problem
 *  determine the right answers
 *  generate 3 wrong answers
 * Set the score to 0
 * Set the starting problem to 1
 * Set the greeting text
 * 
 * display the user the problems one at a time
 *  display the first problem to the use
 *  Make sure we can change the problems easily
 *  Provide clickable boxes
 * 
 * Makes sure the right answer displays with random wrong answers
 * 
 * Count the number of correct answers
 * 
 * Keep track of what problem number they are on and display it
 * 
 * Advance to the next question when they select an answer
 * 
 * When the last question answered hind intro text the problem and answers
 */
let score = 0;
let currentProblem = 1;
const PROBLEMS_IN_SET = 10;
let problemSet = [];

// Start up processing
document.addEventListener('DOMContentLoaded', () => {
    generateProblemSet(); // Randomly generate the problems and answers
    displayProblemSet();


 // End of DOMContentLoaded event listener


// Randomly generate a problem set 

function generateProblemSet() {
    
    for (let i = 0; i < PROBLEMS_IN_SET; i++) {
        // generate a problem
        // create an object
        const problem = {
            leftValue: generateRandomNumber(10),
            rightValue: generateRandomNumber(10),
            answer: null // the correct answer
            
        }
        
        const correctAnswer = problem.leftValue * problem.rightValue;

        // 81 is the max answer 
        const answerChoices = shuffleArray([correctAnswer, generateRandomNumber(82), generateRandomNumber(82), generateRandomNumber(82)])
        problem.answer = answerChoices;
        problemSet.push(problem);
    } 
}

function displayProblemSet() {
    displayProblem()
    displayAnswers()
}

function displayProblem() {
    const problemContainer = document.getElementById('problem')
    const expression = `${problemSet[currentProblem-1].leftValue} * ${problemSet[currentProblem-1].rightValue}`
    problemContainer.querySelector('div.expression').innerText = expression
}

function displayAnswers() {
    const answerContainer = document.getElementById('answers');
    const listOfAnswers = answerContainer.querySelector('ul')
    const theListItems = listOfAnswers.querySelectorAll('li')
    const theAnswers = problemSet[currentProblem-1].answer;
    for (let i = 0; i < theAnswers.length; i++) {
        theListItems[i].innerText = theAnswers[i];
    }
}

/**
 * Utility function to get random number based on max
 * @param {number} max
 */
function generateRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max))
}

function shuffleArray() {
    
}
})
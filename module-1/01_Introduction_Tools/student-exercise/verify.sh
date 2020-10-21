# This exercise validates that the students completed the steps as 
# specified in the README correctly.
# 
# The output the users see is piped into a submission.txt file

ERRORS=0
BASE=~/playground
OUTPUT=submission.txt

clear
echo ""
echo "---- VERIFYING  ---- " | tee $OUTPUT
echo ""

PATHS=("" "/usa" "/canada" "/usa/ohio" "/usa/pennsylvania" "/usa/michigan" "/canada/quebec" "/canada/british columbia" "/usa/ohio/cuyahoga" 
"/usa/ohio/hamilton" "/usa/ohio/franklin" "/usa/pennsylvania/allegheny" "/usa/michigan/wayne" "/usa/ohio/cuyahoga/cleveland.txt" "/usa/ohio/hamilton/cincinnati.txt" 
"/usa/ohio/franklin/columbus.txt" "/usa/pennsylvania/allegheny/pittsburgh.txt" "/usa/michigan/wayne/detroit.txt" "/canada/quebec/montreal.txt" "/canada/quebec/quebec-city.txt" 
"/canada/british columbia/vancouver.txt" "/canada/british columbia/prince-george.txt")

EXERCISE_COUNT="${#PATHS[@]}"

for i in "${!PATHS[@]}"
do        
    STEP=$((i+1))
    PATH_TO_CHECK="${PATHS[$i]}"    
    
    if test -f "$BASE$PATH_TO_CHECK" || test -d "$BASE$PATH_TO_CHECK"; then
        echo "✅ $STEP. ~/playground$PATH_TO_CHECK exists" | tee -a $OUTPUT
    else
        echo "❗️ $STEP. ~/playground$PATH_TO_CHECK does not exist" | tee -a $OUTPUT
        ERRORS=$((ERRORS+1))
    fi        
done

echo "" | tee -a $OUTPUT
echo "$((EXERCISE_COUNT-ERRORS))/$EXERCISE_COUNT tests pass" | tee -a $OUTPUT
echo ""

if ((ERRORS==0)); then
    echo "Congratulations! All tests are passing."
    echo "Continue on to Step 3 in the README to submit your exercise."
    echo ""
fi

if ((ERRORS>0)); then
    echo " You need to make a few more changes still."
    echo " If you are having difficulty troubleshooting, try the following:"
    echo " - Use 'pwd' to print out your current working directory."
    echo " - Check for typos in the names of folders or file paths."
    echo " - When changing directories, '..' means up one directory. '.' means the current directory."    
    echo " - Reference Finder (Mac) or Explorer (PC) to make sure everything is in the correct location."    
    echo ""
fi
echo "enter commit: "
read commit

git status
git add .
git status

git commit -m "$commit"
git push

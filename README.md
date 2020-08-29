# The Readability Score program
The program estimates the readability score of a text. To complete this task, it uses four readability indeces:
1. ARI (the Automated readability index);
2. FK (the Flesch–Kincaid readability index);
3. SMOG (the Simple Measure of Gobbledygook index);
4. CL (the Coleman–Liau index);

The result of evaluating the text using these indices is the optimal age of a person who can easily read it.
### For Example

![picture](https://github.com/Yury-Borovoy/Readability-Score/blob/master/indexes.jpg)
## The Automated readability index
The index is calculated by the following formula:

![picture](https://github.com/Yury-Borovoy/Readability-Score/blob/master/ARI.jpg)
## The Flesch–Kincaid readability index
The index is calculated using the quantity of syllables in a word:

![picture](https://github.com/Yury-Borovoy/Readability-Score/blob/master/FK.jpg)
## The Simple Measure of Gobbledygook index
The index is calculated by counting the number of polysyllables which is the number of words with more than 2 syllables.

![picture](https://github.com/Yury-Borovoy/Readability-Score/blob/master/SMOG.jpg)
## The Coleman–Liau index
The index is calculated using next parameteres: L is the average number of characters per 100 words and S is the average number of sentences per 100 words.

![picture](https://github.com/Yury-Borovoy/Readability-Score/blob/master/CL.jpg)
 ## How does it work?
 In this project you can calculate the readability score of a text using one of the four indeces or using the average of four indeces. The program reads a text from a file and finds the next values: symbols, words, sentences, syllables, polysyllables. Then the program calculates the indeces and outputs the information about the difficulty of the text.
 
 ![picture](https://github.com/Yury-Borovoy/Readability-Score/blob/master/program.jpg)
 
 
 

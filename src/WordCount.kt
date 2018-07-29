import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {

    for(arg in args){
        println(arg)
    }
    //Read from the file and turn into a string .test.txt > allTheWords
    val inputStream: InputStream = File("glass.txt").inputStream()

    val allTheWords = inputStream.bufferedReader().use { it.readText() }
    //val allTheWords = "Hello My name is Maryna, how are you? I am okay I like to say, it's a nice thing to say"

    //Make a list of all the words seperated out
    val words = allTheWords.replace(":", "").replace("\n", "").replace(",", "").replace("!", "").replace("?", "").replace(".", "").split(" ")

//    for (word in words) {
//        println(word)
//    }
    //Get the a counted list of all the words
    val wordMap = mutableMapOf<String, Int>()
    for (word in words) {
        if (word !== ""){

            if (wordMap[word.capitalize()] == null){
                //the world needs to be added
                wordMap[word.capitalize()] = 1
            }else{
                val wordCount = wordMap[word.capitalize()]!!
                wordMap[word.capitalize()] = wordCount + 1
            }
        }


    }

    for (word in wordMap){
        println(word)
    }

    //Convert map to list
    val wordList = wordMap.toList()

    //Sort the list
    val sortedList = wordList.sortedWith(compareByDescending({it.second}))
//    for (word in wordList){
//        println(word)
//    }
    //print a sorted list of the most pupular words
    for (word in wordList){
        println("${word.first} - ${word.second}")
    }

}
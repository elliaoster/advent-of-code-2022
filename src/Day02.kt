
val ELF_ROCK = "A"
val ELF_PAPER = "B"
val ELF_SCISSORS = "C"

val MY_ROCK = "X"
val MY_PAPER = "Y"
val MY_SCISSORS = "Z"

val SHOULD_LOSE = "X"
val SHOULD_DRAW = "Y"
val SHOULD_WIN = "Z"


val LOSE= 0
val DRAW= 3
val WIN= 6

fun main() {
    //The score for a single round is the score for the shape you selected
    // (1 for Rock, 2 for Paper, and 3 for Scissors)
    // plus the score for the outcome of the round
    // (0 if you lost, 3 if the round was a draw, and 6 if you won)

    fun part1(input: List<String>): Int {
        var totalScore = 0

        for (round in input) {
            val elfPlay = round.split(" ").first()
            val myPlay = round.split(" ").last()

            if (elfPlay==ELF_ROCK) {
                if (myPlay==MY_ROCK) {
                    totalScore+=DRAW+1
                } else if (myPlay==MY_PAPER) {
                    totalScore+=WIN+2
                } else if (myPlay==MY_SCISSORS) {
                    totalScore+=LOSE+3
                }
            } else if (elfPlay==ELF_PAPER) {
                if (myPlay==MY_ROCK) {
                    totalScore+=LOSE+1
                } else if (myPlay==MY_PAPER) {
                    totalScore+=DRAW+2
                } else if (myPlay==MY_SCISSORS) {
                    totalScore+=WIN+3
                }
            } else if (elfPlay==ELF_SCISSORS) {
                if (myPlay==MY_ROCK) {
                    totalScore+=WIN+1
                } else if (myPlay==MY_PAPER) {
                    totalScore+=LOSE+2
                } else if (myPlay==MY_SCISSORS) {
                    totalScore+=DRAW+3
                }
            }
            //println(totalScore)
        }

        return totalScore
    }

    fun part2(input: List<String>): Int {
        var totalScore = 0

        for (round in input) {
            val elfPlay = round.split(" ").first()
            val myPlay = round.split(" ").last()

            if (elfPlay==ELF_ROCK) {
                if (myPlay==SHOULD_LOSE) {
                    totalScore+=LOSE+3
                } else if (myPlay==SHOULD_DRAW) {
                    totalScore+=DRAW+1
                } else if (myPlay==SHOULD_WIN) {
                    totalScore+=WIN+2
                }
            } else if (elfPlay==ELF_PAPER) {
                if (myPlay==SHOULD_LOSE) {
                    totalScore+=LOSE+1
                } else if (myPlay==SHOULD_DRAW) {
                    totalScore+=DRAW+2
                } else if (myPlay==SHOULD_WIN) {
                    totalScore+=WIN+3
                }
            } else if (elfPlay==ELF_SCISSORS) {
                if (myPlay==SHOULD_LOSE) {
                    totalScore+=LOSE+2
                } else if (myPlay==SHOULD_DRAW) {
                    totalScore+=DRAW+3
                } else if (myPlay==SHOULD_WIN) {
                    totalScore+=WIN+1
                }
            }
            //println(totalScore)
        }

        return totalScore
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
   check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

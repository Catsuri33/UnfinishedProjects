package com.insignic.bot.utils;

public class XPPercentageBar {

    public static String setXPBar(Integer amountXP, Integer xpGoal){

        final Integer percentage = (amountXP * 100) / xpGoal;

        if(percentage >= 10 && percentage < 20){

            return "\uD83D\uDFE6⬛⬛⬛⬛⬛⬛⬛⬛⬛";

        }

        if(percentage >= 20 && percentage < 30){

            return "\uD83D\uDFE6\uD83D\uDFE6⬛⬛⬛⬛⬛⬛⬛⬛";

        }

        if(percentage >= 30 && percentage < 40){

            return "\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6⬛⬛⬛⬛⬛⬛⬛";

        }

        if(percentage >= 40 && percentage < 50){

            return "\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6⬛⬛⬛⬛⬛⬛";

        }

        if(percentage >= 50 && percentage < 60){

            return "\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6⬛⬛⬛⬛⬛";

        }

        if(percentage >= 60 && percentage < 70){

            return "\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6⬛⬛⬛⬛";

        }

        if(percentage >= 70 && percentage < 80){

            return "\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6⬛⬛⬛";

        }

        if(percentage >= 80 && percentage < 90){

            return "\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6⬛⬛";

        }

        if(percentage >= 90 && percentage < 100){

            return "\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6⬛";

        }

        if(percentage == 100){

            return "\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6\uD83D\uDFE6";

        }

        return "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛";

    }

}

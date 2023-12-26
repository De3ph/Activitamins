package com.example.activitamins.data

import com.example.activitamins.data.entity.Activities
import java.util.Date

data class ActivitiesData(
    val id: Int,
    val title: String,
    var date: Date,
    val description: String,
    val organizer: String,
    var isFavourite: Boolean = false,
    var attendedUserNumber: Int = 0,
    var isUserAttended: Boolean = false
) {

}

val dummyData = arrayOf(
    Activities(
        "Conference on AI",
        Date(),
        "Have fun with this",
        "Tech Events Inc.",
        true,
        attendedUserNumber = 12238,
        isUserAttended = true
    ),
    Activities(
        "Music Festival",
        Date(),
        "Have fun with this",
        "Music Festivals Co.",
        attendedUserNumber = 1543
    ),
    Activities(
        "Fitness Workshop",
        Date(),
        "Have fun with this",
        "Health and Fitness LLC",
        attendedUserNumber = 98,
        isUserAttended = true
    ),
    Activities(
        "Community Cleanup",
        Date(),
        "Have fun with this",
        "Green Earth Organization",
        attendedUserNumber = 0
    ),
    Activities(
        "Tech Meetup",
        Date(),
        "Have fun with this",
        "Tech Enthusiasts Group",
        true,
        attendedUserNumber = 238
    ),
    Activities(
        "Art Exhibition",
        Date(),
        "Have fun with this",
        "Creative Arts Society",
        attendedUserNumber = 2060
    ),
    Activities(
        "Food Tasting",
        Date(),
        "Have fun with this",
        "Culinary Explorers Club",
        true,
        attendedUserNumber = 853
    ),
    Activities(
        "Career Fair",
        Date(),
        "Have fun with this",
        "Job Seekers Network",
        attendedUserNumber = 51,
        isUserAttended = true
    ),
    Activities(
        "Film Screening",
        Date(),
        "Have fun with this",
        "Film Buffs Association",
        attendedUserNumber = 99
    ),
    Activities(
        "Science Symposium",
        Date(),
        "Have fun with this",
        "Scientific Research Institute",
        attendedUserNumber = 126
    ),
    Activities(
        "Book Club Meeting",
        Date(),
        "Have fun with this",
        "Bookworms Society",
        true,
        attendedUserNumber = 18
    ),
    Activities(
        "Fashion Show",
        Date(),
        "Have fun with this",
        "Fashion Designers Guild",
        attendedUserNumber = 395,
        isUserAttended = true
    ),
    Activities(
        "Spring Animations in InDesign with Mrs Fisenkci",
        Date(),
        "Complete Tutorial on how to create animations in InDesign",
        "Adobe Academy",
        attendedUserNumber = 395,
        isUserAttended = true
    )
)


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
        isUserAttended = true,
        tag = Tag.Informative,
    ),
    Activities(
        "Music Festival",
        Date(),
        "Have fun with this",
        "Music Festivals Co.",
        attendedUserNumber = 1543,
        tag = Tag.ArtMusic,

        ),
    Activities(
        "Fitness Workshop",
        Date(),
        "Have fun with this",
        "Health and Fitness LLC",
        attendedUserNumber = 98,
        isUserAttended = true,
        tag = Tag.Sport
    ),
    Activities(
        "Community Cleanup",
        Date(),
        "Have fun with this",
        "Green Earth Organization",
        attendedUserNumber = 0,
        tag = Tag.Nature
    ),
    Activities(
        "Tech Meetup",
        Date(),
        "Have fun with this",
        "Tech Enthusiasts Group",
        true,
        attendedUserNumber = 238,
        tag = Tag.Informative

    ),
    Activities(
        "Art Exhibition",
        Date(),
        "Have fun with this",
        "Creative Arts Society",
        attendedUserNumber = 2060,
        tag = Tag.ArtMusic

    ),
    Activities(
        "Food Tasting",
        Date(),
        "Have fun with this",
        "Culinary Explorers Club",
        true,
        attendedUserNumber = 853,
        tag = Tag.Food
    ),
    Activities(
        "Career Fair",
        Date(),
        "Have fun with this",
        "Job Seekers Network",
        attendedUserNumber = 51,
        isUserAttended = true,
        tag = Tag.Informative
    ),
    Activities(
        "Film Screening",
        Date(),
        "Have fun with this",
        "Film Buffs Association",
        attendedUserNumber = 99,
        tag = Tag.ArtMusic
    ),
    Activities(
        "Science Symposium",
        Date(),
        "Have fun with this",
        "Scientific Research Institute",
        attendedUserNumber = 126,
        tag = Tag.Science
    ),
    Activities(
        "Book Club Meeting",
        Date(),
        "Have fun with this",
        "Bookworms Society",
        true,
        attendedUserNumber = 18,
        tag = Tag.Cultural
    ),
    Activities(
        "Fashion Show",
        Date(),
        "Have fun with this",
        "Fashion Designers Guild",
        attendedUserNumber = 395,
        isUserAttended = true,
        tag = Tag.Fashion
    ),
    Activities(
        "Spring Animations in InDesign with Mrs Fisenkci",
        Date(),
        "Complete Tutorial on how to create animations in InDesign",
        "Adobe Academy",
        attendedUserNumber = 395,
        isUserAttended = true,
        tag = Tag.Informative
    )
)


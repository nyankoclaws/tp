---
layout: default.md
title: "Laraine's Project Portfolio Page"
---

# Project: Dormie
![Image of Dormie](../images/Dormie.png)

## Project Overview
![Image of Dormie](../images/Ui.png)
Dormie is an application developed for college students living in dorms. It helps them connect with their dorm mates in a simple way. With Dormie, they can easily see when their friends are free, and keep track of their important dates and contact details. It makes organising social events less stressful and helps students stay connected with each other.

## Technical Details
Developed with Java and JavaFX, the application employs object-oriented classes to maintain code consistency and organization.

## Challenges and Problem Solving
One challenge I faced was devising an efficient algorithm to display the availability of friends. Specifically, I needed to create commands that would allow for the quick addition and deletion of free time tags for each contact. To tackle this, I shifted my focus from prioritizing speed to accuracy. The latter was more crucial because my solution had to be bug-free to enhance user experience, which was a primary focus of our project.

Additionally, as the group leader, I encountered the challenge of managing project timelines to prevent overruns. Initially, we brainstormed numerous features to enhance Dormie's functionality. However, given our limited one-month timeframe for implementation, I mitigated this challenge by conducting triage and prioritizing features based on their usefulness. 

Overall, the support from everyone in the team eventually allowed for the successful completion of the project!

## Results and Impact
After three productive iterations, we successfully developed Dormie, a user-friendly application that empowers students to make the most of its features with an easy-to-follow user guide. Dormie now facilitates effortless and purposeful bonding within student dormitories.

## My contributions to the project
### Code contributed: [RepoSense link](https://nus-cs2103-ay2324s2.github.io/tp-dashboard/?search=laraine&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23&tabOpen=true&tabType=authorship&tabAuthor=larainezo&tabRepo=AY2324S2-CS2103T-F11-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)
* **New Feature: Added the ability to add/remove freeTime tags.**
  * What it does: allows the user to add/remove freeTime tags for each contact.
  * Justification: This feature improves the product significantly because different contacts can have changing free time and the app should provide a convenient way to modify them.
  * Highlights: The implementation was challenging as it required changes to existing add/edit contact commands and modifications to data structures (i.e. HashSet).
  * `addTime` command: [\#94](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/94)
  * `deleteTime` command: [\#86](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/86)
* **Modified existing features**:
  * Updated the types of data that is stored for each contact - Telegram handle, room number, birthday. [\#43](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/43)
* **Project management**:
  * Managed releases `v1.1` - `v1.4` (4 releases) on GitHub
* **Enhancements to features**:
  * Wrote additional tests for add/remove freeTime tag commands [\#94](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/94) [\#86](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/86)
  * Added welcome message and a quick guide to display to users when the application starts [\#124](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/124)
  * Added logging for actions performed on contact [\#92](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/92)

### Documentation
  * User Guide:
    * Added documentation for the features `addTime` and `deleteTime` [\#221](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/221)
    * Added instructions on how to use the documentation [\#129](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/129)
    * Did cosmetic tweaks to existing documentation of features [\#139](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/139)
  * Developer Guide:
    * Added implementation details of the `addTime` feature. [\#87](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/87)
    * Added implementation details of the `deleteTime` feature. [\#231](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/231)
### Community
  * PRs reviewed (with non-trivial review comments): [\#78](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/78

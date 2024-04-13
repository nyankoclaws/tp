---
layout: default.md
title: "Zoe's Project Portfolio Page"
---

## Project: Dormie

Dormie is an application which revolutionises the way students manage and enhance their social lives on campus. With Dormie, you can effortlessly create and update student contacts, adding a plethora of personal details for a comprehensive directory. The application is optimised for swift contact searches, ensuring you can locate your peers quickly without the hassle of calling friends or sifting through endless texts. It allows you to see when friends are free, and keep track of their important dates and contact details, reducing the friction to organising social events and helping students grow closer each other.

### Contributions

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s2.github.io/tp-dashboard/?search=nyankoclaws&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23&tabOpen=true&tabType=authorship&tabAuthor=nyankoclaws&tabRepo=AY2324S2-CS2103T-F11-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)
* **New Feature**: Added the ability to use different functions for front and back end data entry.
  * What it does: Allows  developer to use separate functions for front and back end data inputs.
  * Justification: This feature allows the adoption of addtional attributes in backend data storage which are transparent to the user.
  * Highlights: The implementation was challenging as it required changes to existing command and storage files. It also required the reworking of test cases for a signficiant amount of the repo.
  * Data entry separation: [\#95](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/95)
* **New Feature**: Added an outdated indicator for room number.
  * What it does: Shows an outdated indicator if the room number was set before the last dorm result release date.
  * Justification: This feature alerts the user about potentially outdated room numbers, so that they can update their contact details.
  * Highlights: The implementation was challenging as it required different functions for both the back and front end, along with the dynamic processing of the current AY given todays date.
  * Last modified for room number: [\#60](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/60)
  * Outdated indicator for room number: [\#106](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/106)
* **Project management**:
  * Managed releases `v1.1` - `v1.4` (4 releases) on GitHub
* **Enhancements to features**:
  * Added an birthday indicator for contacts birthdays [\#106](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/106)
  * Updated teams regex for fields when requested [\#136](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/136) [\#138](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/138)
  * Wrote additional tests for room number and free time tag [\#122](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/122) [\#132](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/132)
* **Documentation**:
  * User Guide:
    * Updated quick start section [\#118](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/118)
    * Updated field specification [\#224](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/224) [\#226](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/226)
  * Developer Guide:

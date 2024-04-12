---
layout: default.md
title: "Donavon's Project Portfolio Page"
---

### Project: Dormie

Dormie is an application developed for college students living in dorms. It helps them connect with their dorm mates in a simple way. With Dormie, they can easily see when their friends are free, and keep track of their important dates and contact details. It makes organising social events less stressful and helps students stay connected with each other.

Given below are my contributions to the project.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s2.github.io/tp-dashboard/?search=donwong2308&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-02-23&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)
* **New Feature**: Added free time tag as a new field for each contact.
    * What it does: Allows users to view when their contacts are free and enables them to perform commands on the free time tag.
    * Justification: This feature improves the product significantly because it makes it more convenient for users to schedule meetups based on the free time slots they can see from the tags on the contacts.
    * Highlights: The implementation was challenging as it required modifications to the tag class and its own custom validity checks for the time interval range as well as its own tests.
    * `freeTimeTag` field: [\#78](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/78)
* **Project management**:
    * Managed releases `v1.1` - `v1.4` (6 releases) on GitHub
* **Enhancements to features**:
    * Enhanced the `telegram` field criteria by making implementing regex that matches the actual Telegram handle criteria [\#53](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/53)
    * Added validity check for the time interval in `freeTimeTag` so that the start time is strictly lesser than the end time along with some tests  [\#130](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/130)
* **Documentation**:
    * User Guide:
        * Updated features section in the User Guide. [\#126](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/126)
        * Added a table for Contact Fields that contains the field name followed by the valid format and examples. [\#137](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/137)
        * Fixed some discrepancies in the User Guide. [\#225](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/225)
    * Developer Guide:
        * Added implementation details of the `freeTimeTag` feature. [\#84](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/84)
* **Community**:
    * PRs reviewed (with non-trivial review comments): [\#86](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/86)

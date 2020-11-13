package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
        int numberOfRacoons = 3;
        int dinnerRacoons = 2;
        int racoonsLeft = numberOfRacoons - dinnerRacoons;
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
        int flower = 5;
        int bees = 3;
        int lessBeesThanFlowers = flower - bees;

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
        int lonelyPigeon = 1;
        int pigeonFriend = 1;
        int pigeonsEatingBread = lonelyPigeon + pigeonFriend;

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
        int owlsFence = 3;
        int owlFriends = 2;
        int owlsNow = owlsFence + owlFriends;

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
        int beaversHome = 2;
        int beaversLeave = 1;
        int beaversNow = beaversHome - beaversLeave;

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
        int toucansSitting = 2;
        int tocanJoins = 1;
        int tocansNow = toucansSitting + tocanJoins;

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
        int squirrels = 4;
        int nuts = 2;
        int squirrelsVsNuts = squirrels - nuts;

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
        int dime = 10;
        int quarter = 25;
        int nickel = 5;
        int hilt = quarter + dime + (2 * nickel);

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
        int briers = 18;
        int macAdams = 20;
        int flannery = 17;
        int bakeInAll = briers + macAdams + flannery;

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
        int yoyo = 20;
        int whistle = 14;
        int moneyAll = yoyo + whistle;

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
        int riceTreats = 5;
        int marshmellow = 8;
        int minimarshmellow = 10;
        int allMarshmellows = marshmellow + minimarshmellow;

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
        int snow = 29;
        int school = 17;
        int moreSnow = snow - school;

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
        int money = 10;
        int truck = 3;
        int pencil = 2;
        int moneyLeft = money - (truck + pencil);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
        int collection = 16;
        int lost = 7;
        int marbles = collection - lost;

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
        int seashells = 19;
        int goal = 25;
        int add = goal - seashells;

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
        int ballons = 17;
        int red = 8;
        int green = ballons - red;

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
        int books = 38;
        int moreBooks = 10;
        int nowBooks = books + moreBooks;
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
        int legs = 6;
        int numberOfBees = 8;
        int legsBeesHave = legs * numberOfBees;

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
        double iceCream = .99;
        int numberOfCones = 2;
        double cost = numberOfCones * iceCream;

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
        int gardenRocks = 125;
        int gardenHas = 64;
        int need = gardenRocks - gardenHas;

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
        int hiltMarbles = 38;
        int hiltLost = 15;
        int hiltMarblesLeft = hiltMarbles - hiltLost;

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
        int hiltDrove = 78;
        int drovePt1 = 38;
        int mileLeft = hiltDrove - drovePt1;

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
        int hiltShovelsMorning = 90;
        int hiltShovelsAfternoon = 45;
        int hiltShovelsTotal = hiltShovelsMorning + hiltShovelsAfternoon;

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
        double hotDogs = 6;
        double hotDogCost = .50;
        double hotDogCostAll = hotDogs * hotDogCost;

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
        double hiltMoney = .50;
        double hiltPencil = .07;
        double pencilsBought = hiltMoney / hiltPencil;

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
        int butterflies = 33;
        int orangeButterflies = 20;
        int redButterflies = butterflies - orangeButterflies;
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
        double kateMoney = 1.00;
        double clerkMoney = 0.54;
        double changeBack = kateMoney - clerkMoney;
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
        int markTrees = 13;
        int markPlantsTree = 12;
        int markTreesNow = markTrees + markPlantsTree;
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
        int hoursInDay = 24;
        int days = 2;
        int untilGrandma = hoursInDay * days;
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
        int kimsCousins = 4;
        int kimsGum = 5;
        int gumNeeded = kimsCousins * kimsGum;
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
        double danMoney = 3.00;
        double candybar = 1.00;
        double moneyAfterBar = danMoney - candybar;
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
        int boatsLake = 5;
        int peopleBoat = 3;
        int peopleLake = boatsLake * peopleBoat;
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
        int ellenLegos = 380;
        int ellenLost = 57;
        int legosNow = ellenLegos - ellenLost;
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
        int muffins = 35;
        int goalMuffins =85;
        int getToGoal = goalMuffins - muffins;
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
        int crayons = 1400;
        int lucyCrayons = 290;
        int moreCrayons = crayons - lucyCrayons;
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
        int stickerPage = 10;
        int myStickers = 22;
        int moreStickers = myStickers - stickerPage;
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
        int cupcakes = 96;
        int children = 8;
        int cupcakesEach = cupcakes / children;
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
        int gingerbread = 47;
        int cookiesPerJar = 6;
        int notInJar = gingerbread % cookiesPerJar;
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
        int croissants = 59;
        int neighbor = 8;
        int croissantsLeft = croissants % neighbor;
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
        int oatmeal = 276;
        int tray = 12;
        int traysNeeded = oatmeal / tray;
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
        int pretzels = 480;
        int serving = 12;
        int prepared = pretzels / serving;
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
        int lemonCupcakes = 53;
        int box = 3;
        int boxes = lemonCupcakes / box;
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
        int carrotSticks = 74;
        int servingCarrots = 12;
        int uneaten = carrotSticks % servingCarrots;
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
        int teddy = 98;
        int shelve = 7;
        int shelvesNeeded = teddy / shelve;
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
        int pictures = 480;
        int album = 20;
        int albumsNeeded = pictures / album;
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
        int card = 94;
        int boxJoe = 8;
        int unfilledBox = card % boxJoe;
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
        int susieBooks = 210;
        int repaired = 10;
        int eachRepair = susieBooks / repaired;
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
        int croissants1 = 17;
        int guestsCristina = 7;
        int equality = croissants1 / guestsCristina;
        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
        int room = 12 * 14;
        double jill = 1.90;
        double bill = 2.15;
        int roomsPaint = 623;
        int hoursADay = 8;
        double hourlyBill = room / bill;
        double hourlyJill = room / jill;
        double hourlyCombined = hourlyJill + hourlyBill;
        int roomAll = room * roomsPaint;
        double hoursAll = roomAll / hourlyCombined;
        double daysAll = hoursAll / hoursADay;
        System.out.println("It will take " + daysAll + " days to paint the rooms");
        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */


	}

}

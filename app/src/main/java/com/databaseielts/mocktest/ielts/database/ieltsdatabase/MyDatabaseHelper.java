package com.databaseielts.mocktest.ielts.database.ieltsdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ielts_listening.db";
    private static final String TABLE_NAME_1 = "MCQs";
    private static final String TABLE_NAME_2 = "FillBlank";
    private static final String TABLE_NAME_3 = "MCQs_Reading";
    private static final String TABLE_NAME_4 = "MatchingThings";
    private static final String TABLE_NAME_5 = "ReadingPassage";
    private static final String TABLE_NAME_6 = "Feedback";
    private static final String feed_Massage = "feed_Massage";
    private static final String f_email = "f_email";
    private static final String ID = "_id";
    private static final String MODULE_NAME = "module_name";
    private static final String TEST_ID = "test_id";
    private static final String SECTION_ID = "section_id";
    private static final String QUESTION_NUMBER = "question_number";
    private static final String QUESTION = "question";
    private static final String A = "a";
    private static final String B = "b";
    private static final String C = "c";
    private static final String D = "d";
    private static final String PASSAGE = "passage";
    private static final String ANSWER = "answer";

    private static final String FIRST_SIDE = "first_side";
    private static final String LAST_SIDE = "last_side";

    private static final String CREATE_TABLE_1 = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_1 +"("+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ TEST_ID +" INTEGER, "+ SECTION_ID +" INTEGER, "+ QUESTION_NUMBER +" INTEGER, "+ QUESTION +" VARCHAR(255), "+ A +" VARCHAR(255), "+ B +" VARCHAR(255), "+ C +" VARCHAR(255), "+ ANSWER +" VARCHAR(255));";
    private static final String CREATE_TABLE_2 = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_2 +"("+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ MODULE_NAME +" TEXT, "+ TEST_ID +" INTEGER, "+ SECTION_ID +" INTEGER, "+ QUESTION_NUMBER +" INTEGER, "+ FIRST_SIDE +" VARCHAR(255), "+ LAST_SIDE +" VARCHAR(255), "+ ANSWER +" VARCHAR(255));";
    private static final String CREATE_TABLE_3 = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_3 +"("+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ TEST_ID +" INTEGER, "+ SECTION_ID +" INTEGER, "+ QUESTION_NUMBER +" INTEGER, "+ QUESTION +" VARCHAR(255), "+ A +" VARCHAR(255), "+ B +" VARCHAR(255), "+ C +" VARCHAR(255), "+ D +"  VARCHAR(255), "+ ANSWER +" VARCHAR(255));";
    private static final String CREATE_TABLE_4 = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_4 +"("+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ TEST_ID +" INTEGER, "+ SECTION_ID +" INTEGER, "+ QUESTION_NUMBER +" INTEGER, "+ QUESTION +" VARCHAR(255), "+ ANSWER +" VARCHAR(255));";
    private static final String CREATE_TABLE_5 = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_5 +"("+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ TEST_ID +" INTEGER, "+ SECTION_ID +" INTEGER, "+ PASSAGE +" TEXT);";
    private static final String CREATE_TABLE_6 = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_6 +"("+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ feed_Massage +" VARCHAR(255), "+ f_email +" VARCHAR(255))";

    private static final int VERSION_NUMBER = 1;

    private Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*try {
            //Toast.makeText(context, "onCreate is called", Toast.LENGTH_SHORT).show();
            //db.execSQL(CREATE_TABLE_1);

        } catch (Exception e) {
            //Toast.makeText(context, "onCreate is failed", Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor fetchData(String module, int testId, int sectionId, int questionNumber) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String fetchDataQuery = "select "+ QUESTION +", "+ A +", "+ B +", "+ C +", "+ ANSWER +" from "+ TABLE_NAME_1 +" where test_id = "+ testId +" and section_id = "+ sectionId +" and question_number = "+ questionNumber;

        Cursor result = sqLiteDatabase.rawQuery(fetchDataQuery, null);

        return result;
    }

    public Cursor fetchTableWholeData(String module, int testId, int sectionId) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String fetchDataQuery = "select "+ QUESTION_NUMBER +", "+ QUESTION +", "+ A +", "+ B +", "+ C +", "+ ANSWER +" from "+ TABLE_NAME_1 +" where test_id = "+ testId +" and section_id = "+ sectionId;

        Cursor result = sqLiteDatabase.rawQuery(fetchDataQuery, null);

        return result;
    }

    public Cursor fetchReadingPassage(int testId, int sectionId) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String fetchDataQuery = "select "+ PASSAGE +" from "+ TABLE_NAME_5 +" where test_id = "+ testId +" and section_id = "+ sectionId;

        Cursor result = sqLiteDatabase.rawQuery(fetchDataQuery, null);

        return result;
    }

    public Cursor fetchMatchingThings(int testId, int sectionId) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String fetchDataQuery = "select "+ QUESTION_NUMBER +", "+ QUESTION +", "+ ANSWER +" from "+ TABLE_NAME_4 +" where test_id = "+ testId +" and section_id = "+ sectionId;

        Cursor result = sqLiteDatabase.rawQuery(fetchDataQuery, null);

        return result;
    }

    public Cursor fetchReadingMCQs(int testId, int sectionId) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String fetchDataQuery = "select "+ QUESTION_NUMBER +", "+ QUESTION +", "+ A +", "+ B +", "+ C +", "+ D +", "+ ANSWER +" from "+ TABLE_NAME_3 +" where test_id = "+ testId +" and section_id = "+ sectionId;

        Cursor result = sqLiteDatabase.rawQuery(fetchDataQuery, null);

        return result;
    }

    public Cursor fetchFillBlankData(String module, int testId, int sectionId) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String fetchDataQuery = "select "+ QUESTION_NUMBER +", "+ FIRST_SIDE +", "+ LAST_SIDE +", "+ ANSWER +" from "+ TABLE_NAME_2 +" where module_name = '"+ module +"' and test_id = "+ testId +" and section_id = "+ sectionId;

        Cursor result = sqLiteDatabase.rawQuery(fetchDataQuery, null);

        return result;
    }

    public Cursor tableExists( String tableName) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor resultSet = sqLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='"+tableName+"';",null);
        return  resultSet;
    }

    public void storeReadingPassage() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.execSQL(CREATE_TABLE_5);

        ContentValues contentValues = new ContentValues();

        // Passage no 1
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        // Pass String values
        contentValues.put(PASSAGE, "<b>READING PASSAGE 1</b><br> <i>You should spend about 20 minutes on <b>questions 1-13,</b> which are based on Reading Passage 1 on the following pages.</i><br><br>" +
                "<b>A song on the brain</b><br><br>" +
                "<b>A </b><br>" +
                "Everyone knows the situation where you can't get a Song out of your head. You hear a pop song on the radio - or even just read the song's title - and it haunts you for hours, playing over and over in your mind until you're heartily sick of it. The condition now even has a medical name - 'Song-in-head syndrome'.<br><br>" +
                "<b>B </b><br>" +
                "But why does the mind annoy us like this? No one knows for Sure, but it's probably because the brain is better at holding onto information than it is at knowing what information is important. Roger Chaffin, a psychologist at the University of Connecticut says. ‘It's a manifestation of an aspect of memory which is normally an asset to us, but in this instance it can be a nuisance.’<br><br>" +
                "<b>B </b><br>" +
                "This eager acquisitiveness of the brain may have helped our ancestors remember important information in the past. Today, students use it to learn new material, and musicians rely on it to memorise complicated pieces. But when this useful function goes awry it can get you stuck on a tune. Unfortunately, superficial pop tunes are, by their very nature, more likely to stick than something more inventive.<br><br>" +
                "<b>D </b><br>" +
                "The annoying playback probably originates in the auditory cortex. Located at the front of the brain, this region handles both listening and playback of music and other sounds. Neuroscientist Robert Zatorre of McGill University in Montreal proved this some years ago when he asked volunteers to replay the theme from the TV show Dallas in their heads. Brain imaging studies showed that this activated the same region of the auditory cortex as when the people actually heard the Song.<br><br>" +
                "<b>E </b><br>" +
                "Not every stored musical memory emerges into consciousness, however. The frontal lobe of the brain gets to decide which thoughts become conscious and which ones are simply stored away. But it can become fatigued or depressed, Which is when people most commonly suffer from song-in-head syndrome and other intrusive thoughts, says Susan Ball, a clinical psychologist at Indiana University School of Medicine in Indianapolis. And once the unwanted song surfaces, it’s hard to stuff it back down into the subconscious. ‘The more you try to suppress a thought, the more you get it,’ says Ball. We call this the pink elephant phenomenon. Tell the brain not to think about pink elephants, and it's guaranteed to do so,’ she says,<br><br>" +
                "<b>F </b><br>" +
                "For those not severely afflicted, simply avoiding certain kinds of music can help. I know certain pieces that are kind of 'sticky' to me, so I will not play them in the early morning for tear that they will run around in my head all day, says Steven Brown, who trained as a classical pianist but is now a neuroscientist at the University of Texas Health Science Centre at San Antonio. He says he always has a song in his head and, even more annoying, his mind never seems to make it all the way through. 'It tends to involve short fragments between, Say, 5 or 15 seconds. They seem to get looped, for hours sometimes,’ he says.<br><br>" +
                "<b>G </b><br>" +
                "Brown's experience of repeated musical loops may represent a phenomenon called 'chunking’, in which people remember musical phrases as a single unit of memory, says Caroline Palmer, a psychologist at Ohio State University in Columbus. Most listeners have little choice about what chunks they remember. Particular chunks may be especially 'sticky' if you hear them often or if they follow Certain predictable patterns, such as the chord progression of rock 'n' roll music. Palmer's research shows that the more a piece of music conforms to these patterns, the easier it is to remember. That's why you're more likely to be haunted by the tunes of pop music than by those of a classical composer such as J. S. Bach.<br><br>" +
                "<b>H </b><br>" +
                "But this ability can be used for good as well as annoyance. Teachers can tap into memory reinforcement by setting their lessons to music. For example, in one experiment students who heard a history text set as the lyrics to a catchy song remembered the words better than those who simply read them, says Sandra Calvert, a psychologist at Georgetown University in Washington DC,<br><br>" +
                "<b>I </b><br>" +
                "This sort of memory enhancement may even explain the origin of music. Before the written word could be used to record history, people memorised it in Songs, says Leon James, a psychologist at the University of Hawaii. And music may have had an even more important role. ‘All music has a message,’ he says. This message functions to unite society and to standardise the thought processes of people in society.’<br><br>");
        sqLiteDatabase.insert(TABLE_NAME_5, null, contentValues);

        // Passage no 2
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        // Pass String values
        contentValues.put(PASSAGE,"<b>READING PASSAGE 2 </b><br><br>" +
                "<i>You should spend about 20 minutes on <b>Questions 14-27,</b> which are based on Reading Passage 2 below.</i><br><br>" +
                "<h3>Worldly Wealth</h3><br>" +
                "The world's population is expected to stabilise at around nine billion. Will it be possible for nine billion people to have the lifestyle enjoyed today only by the wealthy? One school of thought says no: not only should the majority of the world's people resign themselves to poverty forever, but rich nations must also revert to simpler lifestyles in order to save the planet.<br>" +
                "Admittedly, there may be political or social barriers to achieving a rich world. But in fact there seems to be no insuperable physical or ecological reason why nine billion people should not achieve a comfortable lifestyle, using technology only slightly more advanced than that which we now possess. In thinking about the future of civilisation, we ought to start by asking what people want. The evidence demonstrates that as people get richer they want a greater range of personal technology, they want lots of room (preferably near or in natural surroundings). and they want greater speed in travel. More possessions, more space, more mobility.<br>" +
                "In the developed world, the personal technologies of the wealthy, including telephones, washing machines and cars, have become necessities within a generation or two. Increasing productivity that results in decreasing costs for such goods has been responsible for the greatest gains in the standard of living, and there is every reason to believe that this will continue.<br>" +
                "As affluence grows, the amount of energy and raw materials used for production of machinery will therefore escalate. But this need not mean an end to the machine age. Rather than being thrown away, materials from old machinery can be recycled by manufacturers. And long before all fossil fuels are exhausted, their rising prices may compel industrial society not only to become more energy efficient but also to find alternative energy sources sufficient for the demands of an advanced technological civilisation - nuclear fission, nuclear fusion, solar energy, chemical photosynthesis, geothermal, biomass or some yet unknown source of energy.<br>" +
                "The growth of cities and suburbs is often seen as a threat to the environment. However, in fact the increasing amount of land consumed by agriculture is a far greater danger than urban sprawl. Stopping the growth of farms is the best way to preserve many of the world's remaining wild areas. But is a dramatic downsizing of farmland possible? Thanks to the growth of agricultural productivity,reforestation and ‘re-wilding' has been under way in the industrial countries for generations. Since 1950 more land in the US has been set aside in parks than has been occupied by urban and suburban growth. And much of what was Farmland in the nineteenth century is now forest again. Taking the best lowa maize growers as the norm for world food productivity, it has been calculated that less than a tenth of present cropland could support a population of 10 billion.<br>" +
                "In The Environment Game, a vision of a utopia that would be at once high-tech and environmentalist, Nigel Calder suggested that 'nourishing but unpalatable primary food produced by industrial techniques - like yeast from petroleum may be fed to animals, so that we can continue to eat our customary meat, eggs, milk, butter, and cheese – and so that people in underdeveloped countries can have adequate supplies of animal protein for the first time.'<br>" +
                "In the long run, tissue-cloning techniques could be used to grow desired portions of meat by themselves. Once their DNA has been extracted to create cow-less steaks and chicken-less drumsticks, domesticated species of livestock, bred for millennia to be stupid or to have grotesquely enhanced traits, should be allowed to become extinct, except for a few specimens in zoos. However, game such as wild deer, rabbits and wild ducks will be ever more abundant as farms revert to wilderness, so this could supplement the laboratory-grown meat in the diets of tomorrow's affluent.<br>" +
                "With rising personal incomes come rising expectations of mobility. This is another luxury of today's rich that could become a necessity of tomorrow's global population - particularly if its members choose to live widely dispersed in a post-agrarian wilderness. In his recent book Free Flight, James Fallows, a pilot as well as a writer, describes serious attempts by both state and private entrepreneurs in the USA to promote an 'air taxi' system within the price range of today's middle class – and perhaps tomorrow's global population.<br>" +
                "Two of the chief obstacles to the science fiction fantasy of the personal plane or hover car are price and danger. While technological improvements are driving prices down, piloting an aircraft in three dimensions is still more difficult than driving a car in two, and pilot error causes more fatalities than driver error. But before long our aircraft and cars will be piloted by computers which are never tired or stressed.<br>" +
                "So perhaps there are some grounds for optimism when viewing the future of civilisation. With the help of technology, and without putting serious strains on the global environment, possessions, space and mobility can be possessions, space and mobility can be achieved for all the projected population of the world.<br>");
        sqLiteDatabase.insert(TABLE_NAME_5, null, contentValues);

        // Passage no 3
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        // Pass String values
        contentValues.put(PASSAGE,"<b>READING PASSAGE 3</b><br><br>" +
                "<i>You should spend about 20 minutes on <b>Questions 28-40,</b> which are based on Reading Passage 3 below.</i><br><br>" +
                "<h3>Space: The Final Archaeological Frontier</h3><br>" +
                "In 1993, University of Hawaii's anthropologist Ben finny, who for much of his career has studied the technology once used by Polynesians to colonize islands in the Pacific, suggested that it would not be premature to begin thinking about the archaeology of Russian and American aerospace site on the Moon and Mars. Finney pointed out that just as today's scholars use archaeological records to investigate how Polynesians diverged culturally as they explored the Pacific, archaeologists will someday study off-Earth sites to trace the development of humans in space. He realised that it was unlikely anyone would be able to conduct fieldwork in the near future, but he was convinced that one day such work would be done.<br>" +
                "There is a growing awareness, however, that it won't be long before both corporate adventurers and space tourists reach the Moon and Mars. There is a wealth of important archaeological sites from the history of space exploration on the Moon and Mars and measures need to be taken to protect these sites. In addition to the threat from profit-seeking Corporations, scholars cite other potentially destructive forces such as souvenir hunting and unmonitored scientific sampling, as has already occurred in explorations of remote Polar Regions. Already in 1999 one company was proposing a robotic lunar rover mission beginning at the site of Tranquility Base and rumbling across the Moon from one archaeological site to another, from the wreck of the Ranger 8 probe to Apollo 17's landing site. The mission, which would leave vehicle tyre-marks all over some of the most famous sites on the Moon, was promoted as a form of theme-park entertainment.<br>" +
                "According to the vaguely worded United Nations Outer Space Treaty of 1967, what it terms 'space junk remains the property of the country that sent the craft or probe into space. But the treaty doesn't explicitly address protection of sites like Tranquility Base, and equating the remains of human exploration of the heavens with 'space junk' leaves them vulnerable to scavengers. Another problem arises through other international treaties proclaiming that land in space cannot be owned by any country or individual. This presents some interesting dilemmas for the aspiring manager of extraterrestrial cultural resources. Does the US own Neil Armstrong's famous first footprints on the Moon but not the lunar dust in which they were recorded? Surely those footprints are as important in the story of human development as those left by hominids at Laetoli, Tanzania. But unlike the toli prints, which have survived for 3.5 million years encased in cement-like ach those at Tranquility Base could be swept away with a casual brush of a space tourist's hand. To deal with problems like these, it may be time to look to innovative international administrative structures for the preservation of historic remains on the new frontier.<br>" +
                "The Moon, with its wealth of sites, will surely be the first destination of archaeologists trained to work in space. But any young scholars hoping to claim the mantle of history’s first lunar archaeologist will be disappointed. That distinction is already taken.<br>" +
                "On November 19, 1969, astronauts Charles Conrad and Alan Bean made a difficult manual landing of the Apollo 12 lunar module in the Moon's Ocean of Storms, just a few hundred feet from an unmanned probe, Surveyor, 3 that had landed in a crater on April 19, 1967. Unrecognised at the time, this was an important moment in the history of science. Bean and Conrad were about to conduct the first archaeological studies on the Moon.<br>" +
                "After the obligatory planting of the American flag and some geological sampling, Conrad and Bean made their way to Surveyor 3, they observed that the probe had bounced after touchdown and carefully photographed the impressions made by its footpads. The whole spacecraft was covered in dust, perhaps kicked up by the landing.<br>" +
                "The astronaut-archaeologists carefully removed the probe's television camera, remote sampling arm, and pieces of tubing. They bagged and labelled these artefacts, and stowed them on hoard their lunar module. On their return to Earth, they passed them onto the Daveson Space Centre in Houston, Texas, and the Hughes Air and Space Corporation in El Segundo, California. There, scientists analysed the changes in these aerospace artefacts.<br>" +
                "One result of the analysis astonished them. A fragment of the television camera revealed evidence of die bacteria Streptococcus mills. For a moment it was thought Conrad and Bean had discovered evidence for life on the Moon, but after further research the real explanation became apparent. While the camera was being installed in the probe prior to the launch, someone sneezed on it. The resulting bacteria had travelled to the Moon, remained in an alternating freezing/boiling vacuum for more than two years, and returned promptly to life upon reaching the safety of a laboratory back on Earth.<br>" +
                "The finding that not even the vastness of space can stop humans from spreading a sore throat was an unexpected spin-off. But the artefacts brought back by Bean and Conrad have a broader significance. Simple as they may seem, they provide the first example of extraterrestrial archaeology and - perhaps more significant for the history of the discipline - formational archaeology, the study of environmental and cultural forces upon the life history of human artefacts in space.<br>");
        sqLiteDatabase.insert(TABLE_NAME_5, null, contentValues);
    }

    public void storeMatchingThings() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.execSQL(CREATE_TABLE_4);

        ContentValues contentValues = new ContentValues();

        // Question no 4
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 4);
        // Pass String values
        contentValues.put(QUESTION, "The memorable nature of some tunes can help other learning processes.");
        contentValues.put(ANSWER, "E");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 5
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 5);
        // Pass String values
        contentValues.put(QUESTION, "Music may not always be stored in the memory in the form of separate notes.");
        contentValues.put(ANSWER, "D");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 6
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 6);
        // Pass String values
        contentValues.put(QUESTION, "People may have started to make music because of their need to remember things.");
        contentValues.put(ANSWER, "F");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 7
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 7);
        // Pass String values
        contentValues.put(QUESTION, "Having a song going round your head may happen to you more often when one part of the brain is tired.");
        contentValues.put(ANSWER, "B");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 8
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 8);
        // Pass String values
        contentValues.put(QUESTION, "a claim that music strengthens social bonds");
        contentValues.put(ANSWER, "I");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 9
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 9);
        // Pass String values
        contentValues.put(QUESTION, "two reasons why some bits of music tend to stick in your mind more than others");
        contentValues.put(ANSWER, "G");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 10
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 10);
        // Pass String values
        contentValues.put(QUESTION, "an example of how the brain may respond in opposition to your wishes");
        contentValues.put(ANSWER, "E");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 11
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 11);
        // Pass String values
        contentValues.put(QUESTION, "the name of the part of the brain where song-in-head syndrome begins");
        contentValues.put(ANSWER, "D");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 12
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 12);
        // Pass String values
        contentValues.put(QUESTION, "examples of two everyday events that can set off song-in-head syndrome");
        contentValues.put(ANSWER, "A");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 13
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 13);
        // Pass String values
        contentValues.put(QUESTION, "a description of what one person does to prevent song-in-head syndrome");
        contentValues.put(ANSWER, "F");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 14
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 14);
        // Pass String values
        contentValues.put(QUESTION, "Today's wealthy people ignore the fact that millions are living in poverty.");
        contentValues.put(ANSWER, "NOT GIVEN");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 15
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 15);
        // Pass String values
        contentValues.put(QUESTION, "There are reasons why the future population of the world may not enjoy a comfortable lifestyle.");
        contentValues.put(ANSWER, "YES");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 16
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 16);
        // Pass String values
        contentValues.put(QUESTION, "The first thing to consider when planning for the future is environmental protection.");
        contentValues.put(ANSWER, "NO");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 17
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 17);
        // Pass String values
        contentValues.put(QUESTION, "As manufactured goods get cheaper, people will benefit more from them.");
        contentValues.put(ANSWER, "YES");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 18
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 18);
        // Pass String values
        contentValues.put(QUESTION, "It may be possible to find new types of raw materials for use in the production of machinery.");
        contentValues.put(ANSWER, "NOT GIVEN");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 19
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 19);
        // Pass String values
        contentValues.put(QUESTION, "The rising prices of fossil fuels may bring some benefits.");
        contentValues.put(ANSWER, "YES");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 28
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 28);
        // Pass String values
        contentValues.put(QUESTION, "Ben finney's main academic work investigates the way that");
        contentValues.put(ANSWER, "E");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 29
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 29);
        // Pass String values
        contentValues.put(QUESTION, "Ben finney thought that in the long term");
        contentValues.put(ANSWER, "B");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 30
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 30);
        // Pass String values
        contentValues.put(QUESTION, "Commercial pressures mean that in the immediate Future");
        contentValues.put(ANSWER, "H");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 31
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 31);
        // Pass String values
        contentValues.put(QUESTION, "Academics are concerned by the fact that in isolated regions on Earth");
        contentValues.put(ANSWER, "A");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 32
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 32);
        // Pass String values
        contentValues.put(QUESTION, "One problem with the 1967 UN treaty is that");
        contentValues.put(ANSWER, "F");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);

        // Question no 33
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 33);
        // Pass String values
        contentValues.put(QUESTION, "The wording of legal agreements over ownership of land in space means that");
        contentValues.put(ANSWER, "D");
        sqLiteDatabase.insert(TABLE_NAME_4, null, contentValues);
    }

    public void storeReadingMCQ() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.execSQL(CREATE_TABLE_3);

        ContentValues contentValues = new ContentValues();

        // Question no 1
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 1);
        // Pass String values
        contentValues.put(QUESTION, "The writer says that 'song-in-head syndrome' may occur because the brain");
        contentValues.put(A, "confuses two different types of memory.");
        contentValues.put(B, "cannot decide what information it needs to retain.");
        contentValues.put(C, "has been damaged by harmful input.");
        contentValues.put(D, "cannot hold onto all the information it processes.");
        contentValues.put(ANSWER, "cannot decide what information it needs to retain.");
        sqLiteDatabase.insert(TABLE_NAME_3, null, contentValues);

        // Question no 2
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 2);
        // Pass String values
        contentValues.put(QUESTION, "A tune is more likely to stay in your head if");
        contentValues.put(A, "it is simple and unoriginal.");
        contentValues.put(B, "you have musical training.");
        contentValues.put(C, "it is part of your culture.");
        contentValues.put(D, "you have a good memory.");
        contentValues.put(ANSWER, "it is simple and unoriginal.");
        sqLiteDatabase.insert(TABLE_NAME_3, null, contentValues);

        // Question no 3
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 3);
        // Pass String values
        contentValues.put(QUESTION, "Robert Zatorre found that a part of the auditory cortex was activated when volunteers");
        contentValues.put(A, "listened to certain types of music.");
        contentValues.put(B, "learned to play a tune on an instrument.");
        contentValues.put(C, "replayed a piece of music after several years.");
        contentValues.put(D, "remembered a tune they had heard previously.");
        contentValues.put(ANSWER, "remembered a tune they had heard previously.");
        sqLiteDatabase.insert(TABLE_NAME_3, null, contentValues);

        // Question no 26
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 26);
        // Pass String values
        contentValues.put(QUESTION, "Greater mobility may be a feature of the future because of changes in");
        contentValues.put(A, "the location of housing.");
        contentValues.put(B, "patterns of employment.");
        contentValues.put(C, "centres of transport.");
        contentValues.put(D, "the distribution of wealth.");
        contentValues.put(ANSWER, "the location of housing.");
        sqLiteDatabase.insert(TABLE_NAME_3, null, contentValues);

        // Question no 27
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 27);
        // Pass String values
        contentValues.put(QUESTION, "Air transport will be safe because of");
        contentValues.put(A, "new types of aircraft.");
        contentValues.put(B, "better training methods.");
        contentValues.put(C, "three-dimensional models.");
        contentValues.put(D, "improved technology.");
        contentValues.put(ANSWER, "improved technology.");
        sqLiteDatabase.insert(TABLE_NAME_3, null, contentValues);
    }

    public void storeFillBlank() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.execSQL(CREATE_TABLE_2);

        ContentValues contentValues = new ContentValues();

        // Question no 6
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 6);
        // Pass String values
        contentValues.put(FIRST_SIDE, "");
        contentValues.put(LAST_SIDE, " furniture etc. in trading post.");
        contentValues.put(ANSWER, "Advertise");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 7
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 7);
        // Pass String values
        contentValues.put(FIRST_SIDE, "");
        contentValues.put(LAST_SIDE, " or sell kitchen things.");
        contentValues.put(ANSWER, "Donate");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 8
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 8);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Get ");
        contentValues.put(LAST_SIDE, "first from second hand shop.");
        contentValues.put(ANSWER, "quote");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 9
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 9);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Give clothes to ");
        contentValues.put(LAST_SIDE, "shop.");
        contentValues.put(ANSWER, "charity");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 10
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 10);
        // Pass String values
        contentValues.put(FIRST_SIDE, "");
        contentValues.put(LAST_SIDE, " fridge and microwave to Andrea.");
        contentValues.put(ANSWER, "sell");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 11
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 11);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Located conveniently at the ");
        contentValues.put(LAST_SIDE, "of Marion Street and Giles Street.");
        contentValues.put(ANSWER, "corner");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 12
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 12);
        // Pass String values
        contentValues.put(FIRST_SIDE, "<h3>WE ARE OPEN FOR YOU</h3>Monday - Friday:");
        contentValues.put(LAST_SIDE, "<p>am to 9.30 pm.<br>Saturday: 9.00 am to 4.00 pm</p>");
        contentValues.put(ANSWER, "6");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 13
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 13);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Sunday: 9.00 am to ");
        contentValues.put(LAST_SIDE, "pm");
        contentValues.put(ANSWER, "2");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 14
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 14);
        // Pass String values
        contentValues.put(FIRST_SIDE, "<h3>WET AREA</h3><p>Aqua aerobic</p>");
        contentValues.put(LAST_SIDE, "<p>for all ages and levels.</p>");
        contentValues.put(ANSWER, "classes");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 15
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 15);
        // Pass String values
        contentValues.put(FIRST_SIDE, "");
        contentValues.put(LAST_SIDE, "lessons on weekday afternoons and weekend mornings.");
        contentValues.put(ANSWER, "swimming");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 16
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 16);
        // Pass String values
        contentValues.put(FIRST_SIDE, "<h3>SUPER CIRCUIT CLASSES</h3>A cardio workout class that is easy to ");
        contentValues.put(LAST_SIDE, "<h3>AEROBIC & STEP CLASSES</h3>Aerobic room holds over 55 participants.");
        contentValues.put(ANSWER, "learn");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 17
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 17);
        // Pass String values
        contentValues.put(FIRST_SIDE, "<h3>LARGE WELL-EQUIPED GYM</h3>Have a personal fitness assessment & individual ");
        contentValues.put(LAST_SIDE, "<p>to suit you.</p>");
        contentValues.put(ANSWER, "programme");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 18
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 18);
        // Pass String values
        contentValues.put(FIRST_SIDE, "<h3>CARDIO-VASCULAR ROOM</h3>Use the treadmills, bikes and steppers to burn fat, increase fitness, warm up. Watch your favourite");
        contentValues.put(LAST_SIDE, "<p>while you exercise.</p>");
        contentValues.put(ANSWER, "videos");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 19
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 19);
        // Pass String values
        contentValues.put(FIRST_SIDE, "<h3>TWO FOR ONE SPECIAL MEMBERSHIP PLUS</h3>");
        contentValues.put(LAST_SIDE, "<h3>TRIAL OFFER</h3>");
        contentValues.put(ANSWER, "Free");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 20
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 20);
        // Pass String values
        contentValues.put(FIRST_SIDE, "<p>Only $110 each for a whole</p>");
        contentValues.put(LAST_SIDE, "<p>months! Get ready for summer.</p><br><h3>HURRY, OFFER ENDS SOON</h3>");
        contentValues.put(ANSWER, "6");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 21
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 21);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Understanding subtle");
        contentValues.put(LAST_SIDE, "between the Canadian and United States food sectors is important for successful food marketing.");
        contentValues.put(ANSWER, "differences");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 22
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 22);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Canada has many different ethnic groups: e.g. Toronto has large");
        contentValues.put(LAST_SIDE, "and Asian populations.");
        contentValues.put(ANSWER, "Italian");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 23
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 23);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Growth of ethnic specialists of Mediterranean, Caribbean, South East Asian and");
        contentValues.put(LAST_SIDE, "foods.");
        contentValues.put(ANSWER, "Mexican");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 24
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 24);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Therefore demand is increasing for new");
        contentValues.put(LAST_SIDE, "to prepapre these foods plus condiments and sauces.<br><br>80% of Canadian market controlled by 8 major national chains.");
        contentValues.put(ANSWER, "ingredients");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 25
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 25);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Seminar of compare Canadian food trends with");
        contentValues.put(LAST_SIDE, "and UK.");
        contentValues.put(ANSWER, "Australia");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 26
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 26);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Salads are the third most commonly eaten food in Canadian");
        contentValues.put(LAST_SIDE, "");
        contentValues.put(ANSWER, "restaurants");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 27
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 27);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Most shoppers check");
        contentValues.put(LAST_SIDE, "and nutritional information.");
        contentValues.put(ANSWER, "fat");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 28
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 28);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Labelled according to");
        contentValues.put(LAST_SIDE, "technique e.g. simmering steak.");
        contentValues.put(ANSWER, "cooking");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 29
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 29);
        // Pass String values
        contentValues.put(FIRST_SIDE, "");
        contentValues.put(LAST_SIDE, "increase in sales of snacks projected over next 3 years.");
        contentValues.put(ANSWER, "40%");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 30
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 30);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Growth in");
        contentValues.put(LAST_SIDE, "snacks such as muesli bars.");
        contentValues.put(ANSWER, "healthy");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 31
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 4);
        contentValues.put(QUESTION_NUMBER, 31);
        // Pass String values
        contentValues.put(FIRST_SIDE, "<h3>PUBLIC SPEAKING</h3>Public speaking means speaking to");
        contentValues.put(LAST_SIDE, "people.");
        contentValues.put(ANSWER, "ten or more");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 32
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 4);
        contentValues.put(QUESTION_NUMBER, 32);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Lack of confidence usually due to");
        contentValues.put(LAST_SIDE, "");
        contentValues.put(ANSWER, "lack of practice");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 33
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 4);
        contentValues.put(QUESTION_NUMBER, 33);
        // Pass String values
        contentValues.put(FIRST_SIDE, "<h3>A. PLANNING</h3>First part of public spekaing is");
        contentValues.put(LAST_SIDE, "this includes");
        contentValues.put(ANSWER, "preparation");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 34
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 4);
        contentValues.put(QUESTION_NUMBER, 34);
        // Pass String values
        contentValues.put(FIRST_SIDE, "");
        contentValues.put(LAST_SIDE, "and length of talk.");
        contentValues.put(ANSWER, "topic");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 35
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 4);
        contentValues.put(QUESTION_NUMBER, 35);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Make speech notes on small cards to talk from.");
        contentValues.put(LAST_SIDE, "with the audience (very important).");
        contentValues.put(ANSWER, "eye contact");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 36
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 4);
        contentValues.put(QUESTION_NUMBER, 36);
        // Pass String values
        contentValues.put(FIRST_SIDE, "<h3>B. VOICE</h3>Speak slowly:<br>this gives time for pronunciationand is easier for audience.<br>bigger audience requires");
        contentValues.put(LAST_SIDE, "");
        contentValues.put(ANSWER, "slower");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 37
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 4);
        contentValues.put(QUESTION_NUMBER, 37);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Project your voice - rehearse and");
        contentValues.put(LAST_SIDE, "");
        contentValues.put(ANSWER, "record");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 38
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 4);
        contentValues.put(QUESTION_NUMBER, 38);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Check intonation: varied tone and rhythm gives");
        contentValues.put(LAST_SIDE, "");
        contentValues.put(ANSWER, "meaning");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 39
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 4);
        contentValues.put(QUESTION_NUMBER, 39);
        // Pass String values
        contentValues.put(FIRST_SIDE, "<h3>B. BODY LANGUAGE</h3>Lastly, think about your");
        contentValues.put(LAST_SIDE, "and gestures.<br>Show your confidence by: head up, chin out, shoulders back.");
        contentValues.put(ANSWER, "posture");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 40
        // Pass String values
        contentValues.put(MODULE_NAME, "listening");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 4);
        contentValues.put(QUESTION_NUMBER, 40);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Avoid scratching and fiddling because this");
        contentValues.put(LAST_SIDE, "and irritates your audience.");
        contentValues.put(ANSWER, "distracts");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 20
        // Pass String values
        contentValues.put(MODULE_NAME, "reading");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 20);
        // Pass String values
        contentValues.put(FIRST_SIDE, "According to the writer, the use of land for");
        contentValues.put(LAST_SIDE, "is the most serious threat to the environment.");
        contentValues.put(ANSWER, "agriculture");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 21
        // Pass String values
        contentValues.put(MODULE_NAME, "reading");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 21);
        // Pass String values
        contentValues.put(FIRST_SIDE, "However, in the US, there has already been an increase in the amount of land used for");
        contentValues.put(LAST_SIDE, "and forests.");
        contentValues.put(ANSWER, "parks");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 22
        // Pass String values
        contentValues.put(MODULE_NAME, "reading");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 22);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Far less land would be required to feed the worlds's population if the");
        contentValues.put(LAST_SIDE, "of the land could be improved worldwide.");
        contentValues.put(ANSWER, "productivity");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 23
        // Pass String values
        contentValues.put(MODULE_NAME, "reading");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 23);
        // Pass String values
        contentValues.put(FIRST_SIDE, "It has also been claimed that the industrial production of animal foods could allow greater access to animal");
        contentValues.put(LAST_SIDE, "by the entire world's population.");
        contentValues.put(ANSWER, "protein");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 24
        // Pass String values
        contentValues.put(MODULE_NAME, "reading");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 24);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Scientists could use");
        contentValues.put(LAST_SIDE, "from domesticated animals to help produce meat by tissue cloning, and these species could then be allowed to die out.");
        contentValues.put(ANSWER, "DNA");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 25
        // Pass String values
        contentValues.put(MODULE_NAME, "reading");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 2);
        contentValues.put(QUESTION_NUMBER, 25);
        // Pass String values
        contentValues.put(FIRST_SIDE, "In addition to this type of meat,");
        contentValues.put(LAST_SIDE, "will also be widely available.");
        contentValues.put(ANSWER, "game");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 34
        // Pass String values
        contentValues.put(MODULE_NAME, "reading");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 34);
        // Pass String values
        contentValues.put(FIRST_SIDE, "During the assembly of Surveyor 3 probe, someone");
        contentValues.put(LAST_SIDE, "on a TV camera.");
        contentValues.put(ANSWER, "sneezed");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 35
        // Pass String values
        contentValues.put(MODULE_NAME, "reading");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 35);
        // Pass String values
        contentValues.put(FIRST_SIDE, "The TV camera remained on the Moon for over");
        contentValues.put(LAST_SIDE, "years.");
        contentValues.put(ANSWER, "two");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 36
        // Pass String values
        contentValues.put(MODULE_NAME, "reading");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 36);
        // Pass String values
        contentValues.put(FIRST_SIDE, "Apollo 12 astronauts");
        contentValues.put(LAST_SIDE, "the TV camera");
        contentValues.put(ANSWER, "sneezed");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 37
        // Pass String values
        contentValues.put(MODULE_NAME, "reading");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 37);
        // Pass String values
        contentValues.put(FIRST_SIDE, "The TV camera was returned to Earth for");
        contentValues.put(LAST_SIDE, "");
        contentValues.put(ANSWER, "analysis");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        // Question no 38
        // Pass String values
        contentValues.put(MODULE_NAME, "reading");
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 3);
        contentValues.put(QUESTION_NUMBER, 38);
        // Pass String values
        contentValues.put(FIRST_SIDE, "The theory that this suggested there was");
        contentValues.put(LAST_SIDE, "on the Moon was rejected.");
        contentValues.put(ANSWER, "life");
        sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);
    }

    public void storeQuestions() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.execSQL(CREATE_TABLE_1);
        sqLiteDatabase.execSQL(CREATE_TABLE_6);

        ContentValues contentValues = new ContentValues();

        // Example
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 0); // Question number "0" means it is a example.
        // Pass String values
        contentValues.put(QUESTION, "Andrea is feeling happy because");
        contentValues.put(A, "she is seen Harry.");
        contentValues.put(B, "she is finished her exams.");
        contentValues.put(C, "she can sleep well.");
        contentValues.put(ANSWER, "she is finished her exams.");
        sqLiteDatabase.insert(TABLE_NAME_1, null, contentValues);

        // Question no 1
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 1);
        // Pass String values
        contentValues.put(QUESTION, "What is Harrys problem?");
        contentValues.put(A, "He does not want to sell his things.");
        contentValues.put(B, "He needs to decide what to do with his possession.");
        contentValues.put(C, "He wants to take everything to England.");
        contentValues.put(ANSWER, "He needs to decide what to do with his possession.");
        sqLiteDatabase.insert(TABLE_NAME_1, null, contentValues);

        // Question no 2
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 2);
        // Pass String values
        contentValues.put(QUESTION, "Which of the items below does Harry want to sell?");
        contentValues.put(A, "computer");
        contentValues.put(B, "tree");
        contentValues.put(C, "fridge");
        contentValues.put(ANSWER, "fridge");
        sqLiteDatabase.insert(TABLE_NAME_1, null, contentValues);

        // Question no 3
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 3);
        // Pass String values
        contentValues.put(QUESTION, "Where is Harry going to advertise his books for sale?");
        contentValues.put(A, "In the university bookshop.");
        contentValues.put(B, "In the student newspaper.");
        contentValues.put(C, "In the economics department.");
        contentValues.put(ANSWER, "In the economics department.");
        sqLiteDatabase.insert(TABLE_NAME_1, null, contentValues);


        // Question no 4
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 4);
        // Pass String values
        contentValues.put(QUESTION, "Andrea thinks it is unlikely student will buy the furniture because");
        contentValues.put(A, "they are all doing the same thing.");
        contentValues.put(B, "they live at home.");
        contentValues.put(C, "it is the summer vacation.");
        contentValues.put(ANSWER, "it is the summer vacation.");
        sqLiteDatabase.insert(TABLE_NAME_1, null, contentValues);

        // Question no 5
        // Pass integer values
        contentValues.put(TEST_ID, 1);
        contentValues.put(SECTION_ID, 1);
        contentValues.put(QUESTION_NUMBER, 5);
        // Pass String values
        contentValues.put(QUESTION, "Andrea thinks that a second hand shop");
        contentValues.put(A, "may not pay well.");
        contentValues.put(B, "may not take Harrys goods.");
        contentValues.put(C, "may only take free goods.");
        contentValues.put(ANSWER, "may not pay well.");
        sqLiteDatabase.insert(TABLE_NAME_1, null, contentValues);
    }
    public long storeFeedback(String msg, String f_email) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("feed_Massage",msg);
        contentValues.put("f_email",f_email);
        long tt = sqLiteDatabase.insert(TABLE_NAME_6, null, contentValues);
        return tt;

    }

}

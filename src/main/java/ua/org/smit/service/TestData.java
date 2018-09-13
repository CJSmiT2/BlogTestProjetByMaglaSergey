/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.org.smit.service;

import ua.org.smit.model.BlogEntity;

/**
 *
 * @author smit
 */
public class TestData {

    public TestData(Dao dao) {
        dao.write(new BlogEntity("","Carrie","Doubleday","World Fantasy Award nominee for Best Novel, 1976[2]"));
        dao.write(new BlogEntity("","'Salem's Lot","Doubleday","World Fantasy Award nominee for Best Novel, 1976[2]"));
        dao.write(new BlogEntity("","The Shining","Doubleday","Runner-up (4th place), Locus Award, 1978[3]"));
        dao.write(new BlogEntity("","Rage","Signet Books","Published under pseudonym Richard Bachman"));
        dao.write(new BlogEntity("","The Stand","Doubleday","Runner-up (15th place), Locus Award, 1979[3]"));
        dao.write(new BlogEntity("","The Long Walk","Signet Books","Published under pseudonym Richard Bachman"));
        dao.write(new BlogEntity("","The Dead Zone","Viking Press","Nominee, British Fantasy Award’s August Derleth Award, 1981; "));
        dao.write(new BlogEntity("","Roadwork","Signet Books","Published under pseudonym Richard Bachman"));
        dao.write(new BlogEntity("","Cujo","Viking Press","Winner, British Fantasy Award’s August Derleth Award, 1982[3]"));
        dao.write(new BlogEntity("","The Running Man","	Signet Books","Published under pseudonym Richard Bachman"));
        dao.write(new BlogEntity("","The Dark Tower: The Gunslinger","Grant","non info"));
        dao.write(new BlogEntity("","Christine","Viking","Nominee, Locus Award, 1984[3]"));
        dao.write(new BlogEntity("","Pet Sematary","Doubleday","Nominee, Locus Award, 1984[3]"));
        dao.write(new BlogEntity("","Cycle of the Werewolf","Land of Enchantment","Illustrated by Bernie Wrightson"));
        dao.write(new BlogEntity("","The Talisman","Viking","Nominee, Locus Award, 1985[3]"));
        dao.write(new BlogEntity("","Thinner","NAL","Published under pseudonym Richard Bachman"));
        dao.write(new BlogEntity("","The Dark Tower II: The Drawing of the Three","Grant","Nominee, Locus Award, 1988[3]"));
        dao.write(new BlogEntity("","Misery","Viking","Nominee, World Fantasy Award, 1988[2]"));
        dao.write(new BlogEntity("","The Tommyknockers","Putnam","Nominee, Locus Award, 1988[3]"));
        dao.write(new BlogEntity("","The Dark Tower III: The Waste Lands","Grant","Nominee, Locus Award, 1991[3]"));
        dao.write(new BlogEntity("","Needful Things","Viking","	Nominee, Locus Award, 1993[3]"));
    }
    
}

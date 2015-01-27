<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="shortcut icon" href="favicon.ico">
<script src="./resources/jqm/1.4.4/demos/js/jquery.js"></script>
 
<script src="./resources/jqwidgets/jqx-all.js"></script>
<!-- <script src="./resources/jqwidgets/jqxcore.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxtabs.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxbuttons.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxinput.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxdata.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxcombobox.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxlistbox.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxscrollbar.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxdatetimeinput.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxcalendar.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxcheckbox.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxwindow.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxdatatable.js"></script> -->
<!-- <script src="./resources/jqwidgets/jqxdata.export.js"></script> -->
<!-- --------------------------------------------------------- -->
<script src="./resources/jqwidgets/globalization/globalize.js"></script>

<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.base.css">
<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.energyblue.css">
<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.office.css">
<link rel="stylesheet" href="./resources/jqwidgets/styles/jqx.orange.css">
<link rel="stylesheet" href="./resources/opec.css">

</head>

<body class='default'>
    <div id='jqxWidget'>
    <H1>Thông Tin Vận Chuyển</H1>
        <div id="tabsWidget">
        <H2>Vận Tải Biển</H2>
            <ul style="margin-left: 30px;">
                <li>Vận tải biển</li>
                <li>Thông tin Thông Quan</li>
                <li>Nộp Thuế</li>
                <li>Giao Hàng</li>
                <li>Chi phí Logitics</li>
            </ul>
            <div>
        <div id="jqxgrid">
        </div>
        <div id="jqxwindow">
            <div>
                Find Record</div>
            <div style="overflow: hidden;">
                <div>
                    Find what:</div>
                <div style='margin-top:5px;'>
                    <input id='inputField' type="text" class="jqx-input" style="width: 200px; height: 23px;" />
                </div>
                <div style="margin-top: 7px; clear: both;">
                    Look in:</div>
                <div style='margin-top:5px;'>
                    <div id='dropdownlist'>
                    </div>
                </div>
                <div>
                    <input type="button" style='margin-top: 15px; margin-left: 50px; float: left;' value="Find" id="findButton" />
                    <input type="button" style='margin-left: 5px; margin-top: 15px; float: left;' value="Clear" id="clearButton" />
                </div>
            </div>
        </div>
            </div>
            <div>
                <img src="../../images/endgame.png" style="float: left; margin: 10px;" alt="" />
                End Game is a 2006 action/thriller film, written and directed by Andy Cheng. The
                                                                        film stars Cuba Gooding, Jr. as Secret Service agent Alex Thomas, who is shot in
                                                                        the hand, while unsuccessfully trying to protect the President (played by Jack Scalia)
                                                                        from an assassin's bullet. Later, with the help of a persistent newspaper reporter
                                                                        named Kate Crawford (played by Angie Harmon), he uncovers a vast conspiracy behind
                                                                        what initially appeared to be a lone gunman. James Woods, Burt Reynolds, and Anne
                                                                        Archer co–star in this film that was originally set to be shown in cinemas by MGM
                                                                        in 2005, but was delayed by the takeover from Sony and eventually sent direct to
                                                                        DVD.
            </div>
            <div>
                <img src="../../images/twilight.png" style="float: left; margin: 10px;" alt="" />
                The project was in development for approximately three years at Paramount Pictures,
                                                                        during which time a screen adaptation that differed significantly from the novel
                                                                        was written. Summit Entertainment acquired the rights to the novel after three years
                                                                        of the project's stagnant development. Melissa Rosenberg wrote a new adaptation
                                                                        of the novel shortly before the 2007–2008 Writers Guild of America strike and sought
                                                                        to be faithful to the novel's storyline. Principal photography took 44 days, and
                                                                        completed on May 2, 2008; the film was primarily shot in Oregon
            </div>
            <div>
                <img src="../../images/unstoppable.png" style="float: left; margin: 10px;" alt="" />
                Meanwhile, in a rail yard within the northern town of Fuller, two AWVR hostlers,
                                                                        Dewey (Ethan Suplee) and Gilleece (T.J. Miller), are ordered by Fuller operations
                                                                        dispatcher Bunny (Kevin Chapman) to move a freight train led by locomotive #777
                                                                        (nicknamed "Triple Seven") off its current track to clear the track for an excursion
                                                                        train carrying schoolchildren. Dewey attempts to take shortcuts, instructing Gilleece
                                                                        to leave the hoses for the air brakes disconnected for the short trip. Dewey later
                                                                        leaves the moving cab to throw a misaligned rail switch along the train's path,
                                                                        but is unable to climb back on, as the train's throttle jumps from idle, to full
                                                                        power. He is forced to report the train as a "coaster" to Fuller yardmaster Connie
                                                                        Hooper (Rosario Dawson)...
            </div>
            <div>
                <img src="../../images/priest.png" style="float: left; margin: 10px;" alt="" />
                Priest is a 2011 American post-apocalyptic sci-fi western and supernatural action
                                                                        film starring Paul Bettany as the title character. The film, directed by Scott Stewart,
                                                                        is based on the Korean comic of the same name. In an alternate world, humanity and
                                                                        vampires have warred for centuries. After the last Vampire War, the veteran Warrior
                                                                        Priest (Bettany) lives in obscurity with other humans inside one of the Church's
                                                                        walled cities. When the Priest's niece (Lily Collins) is kidnapped by vampires,
                                                                        the Priest breaks his vows to hunt them down. He is accompanied by the niece's boyfriend
                                                                        (Cam Gigandet), who is a wasteland sheriff, and a former Warrior Priestess (Maggie
                                                                        Q).
            </div>
        </div>
        <br />
    </div>
</body>
<script src="./resources/opec/dm_common.js"></script>
<script src="./resources/opec/dm_hang_tau_bien.js"></script>
<script src="./resources/opec/dm_don_vi_van_tai.js"></script>
<script src="./resources/opec/xnk_nk_van_tai.js"></script>
    <script type="text/javascript" src="./resources/jqwidgets/generatedata.js"></script>


<script type="text/javascript">
 	
	$(document).ready(function () {
        // Create jqxTabs.
        $('#tabsWidget').jqxTabs({ width: 1200, height: 350, position: 'top'});
        // Focus jqxTabs.
        $('#tabsWidget').jqxTabs('focus');
        var getAdapter = function () {
            // prepare the data
            var data = generatedata(2);

            var source =
            {
                localdata: data,
                datatype: "array",
                datafields:
                [
                    { name: 'firstname', type: 'string' },
                    { name: 'lastname', type: 'string' },
                    { name: 'productname', type: 'string' },
                    { name: 'quantity', type: 'number' },
                    { name: 'price', type: 'number' },
                    { name: 'available', type: 'bool' }
                ],
                updaterow: function (rowid, rowdata, commit) {
                    // synchronize with the server - send update command
                    // call commit with parameter true if the synchronization with the server is successful 
                    // and with parameter false if the synchronization failed.
                    commit(true);
                }
            };

            var dataAdapter = new $.jqx.dataAdapter(source);
            return dataAdapter;
        }

        // initialize jqxGrid
        $("#jqxgrid").jqxGrid(
        {
            width: 950,
            height:150,
            source: getAdapter(),               
            showstatusbar: true,
            renderstatusbar: function (statusbar) {
                // appends buttons to the status bar.
                var container = $("<div style='overflow: hidden; position: relative; margin: 5px;'></div>");
                var addButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='./resources/images/add.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Add</span></div>");
                var deleteButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='./resources/images/close.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Delete</span></div>");
                var reloadButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='./resources/images/refresh.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Reload</span></div>");
                var searchButton = $("<div style='float: left; margin-left: 5px;'><img style='position: relative; margin-top: 2px;' src='./resources/images/search.png'/><span style='margin-left: 4px; position: relative; top: -3px;'>Find</span></div>");
                container.append(addButton);
                container.append(deleteButton);
                container.append(reloadButton);
                container.append(searchButton);
                statusbar.append(container);
                addButton.jqxButton({  width: 60, height: 20 });
                deleteButton.jqxButton({  width: 65, height: 20 });
                reloadButton.jqxButton({  width: 65, height: 20 });
                searchButton.jqxButton({  width: 50, height: 20 });
                // add new row.
                addButton.click(function (event) {
                    var datarow = generatedata(1);
                    $("#jqxgrid").jqxGrid('addrow', null, datarow[0]);
                });
                // delete selected row.
                deleteButton.click(function (event) {
                    var selectedrowindex = $("#jqxgrid").jqxGrid('getselectedrowindex');
                    var rowscount = $("#jqxgrid").jqxGrid('getdatainformation').rowscount;
                    var id = $("#jqxgrid").jqxGrid('getrowid', selectedrowindex);
                    $("#jqxgrid").jqxGrid('deleterow', id);
                });
                // reload grid data.
                reloadButton.click(function (event) {
                    $("#jqxgrid").jqxGrid({ source: getAdapter() });
                });
                // search for a record.
                searchButton.click(function (event) {
                    var offset = $("#jqxgrid").offset();
                    $("#jqxwindow").jqxWindow('open');
                    $("#jqxwindow").jqxWindow('move', offset.left + 30, offset.top + 30);
                });
            },
            columns: [
              { text: 'First Name', columntype: 'textbox', datafield: 'firstname', width: 120 },
              { text: 'Last Name', datafield: 'lastname', columntype: 'textbox', width: 120 },
              { text: 'Product', datafield: 'productname', width: 170 },
              { text: 'In Stock', datafield: 'available', columntype: 'checkbox', width: 125 },
              { text: 'Quantity', datafield: 'quantity', width: 85, cellsalign: 'right', cellsformat: 'n2' },
              { text: 'Price', datafield: 'price', cellsalign: 'right', cellsformat: 'c2' }
            ]
        });

        // create jqxWindow.
        $("#jqxwindow").jqxWindow({ resizable: false,  autoOpen: false, width: 210, height: 180 });
        // create find and clear buttons.
        $("#findButton").jqxButton({ width: 70});
        $("#clearButton").jqxButton({ width: 70});
        // create dropdownlist.
        $("#dropdownlist").jqxDropDownList({ autoDropDownHeight: true, selectedIndex: 0, width: 200, height: 23, 
            source: [
                'First Name', 'Last Name', 'Product', 'Quantity', 'Price'
            ]
        });

        if (theme != "") {
            $("#inputField").addClass('jqx-input-' + theme);
        }

        // clear filters.
        $("#clearButton").click(function () {
            $("#jqxgrid").jqxGrid('clearfilters');
        });

        // find records that match a criteria.
        $("#findButton").click(function () {
            $("#jqxgrid").jqxGrid('clearfilters');
            var searchColumnIndex = $("#dropdownlist").jqxDropDownList('selectedIndex');
            var datafield = "";
            switch (searchColumnIndex) {
                case 0:
                    datafield = "firstname";
                    break;
                case 1:
                    datafield = "lastname";
                    break;
                case 2:
                    datafield = "productname";
                    break;
                case 3:
                    datafield = "quantity";
                    break;
                case 4:
                    datafield = "price";
                    break;
            }

            var searchText = $("#inputField").val();
            var filtergroup = new $.jqx.filter();
            var filter_or_operator = 1;
            var filtervalue = searchText;
            var filtercondition = 'contains';
            var filter = filtergroup.createfilter('stringfilter', filtervalue, filtercondition);
            filtergroup.addfilter(filter_or_operator, filter);
            $("#jqxgrid").jqxGrid('addfilter', datafield, filtergroup);
            // apply the filters.
            $("#jqxgrid").jqxGrid('applyfilters');
        });        
		
	});
  
</script>


</html>
package library.locale.corejava.v2ch07.dateFormat;

import corejava.v2ch07.dateFormat.EnumCombo;
import corejava.v2ch07.dateFormat.GBC;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

import javax.swing.*;

/**
 * This program demonstrates formatting dates under various locales.
 * @version 1.00 2016-05-06
 * @author Cay Horstmann
 */
public class DateTimeFormatterTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(() ->
         {
            JFrame frame = new DateTimeFormatterFrame();
            frame.setTitle("DateFormatTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         });
   }
}

/**
 * This frame contains combo boxes to pick a locale, date and time formats, text fields to display
 * formatted date and time, buttons to parse the text field contents, and a "lenient" check box.
 */
class DateTimeFormatterFrame extends JFrame
{
   private Locale[] locales;
   private LocalDate currentDate;
   private LocalTime currentTime;
   private ZonedDateTime currentDateTime;
   private DateTimeFormatter currentDateFormat;
   private DateTimeFormatter currentTimeFormat;
   private DateTimeFormatter currentDateTimeFormat;
   private JComboBox<String> localeCombo = new JComboBox<>();
   private JButton dateParseButton = new JButton("Parse");
   private JButton timeParseButton = new JButton("Parse");
   private JButton dateTimeParseButton = new JButton("Parse");
   private JTextField dateText = new JTextField(30);
   private JTextField timeText = new JTextField(30);
   private JTextField dateTimeText = new JTextField(30);
   private corejava.v2ch07.dateFormat.EnumCombo<FormatStyle> dateStyleCombo = new corejava.v2ch07.dateFormat.EnumCombo<>(FormatStyle.class,
         "Short", "Medium", "Long", "Full");
   private corejava.v2ch07.dateFormat.EnumCombo<FormatStyle> timeStyleCombo = new corejava.v2ch07.dateFormat.EnumCombo<>(FormatStyle.class,
         "Short", "Medium");
   private corejava.v2ch07.dateFormat.EnumCombo<FormatStyle> dateTimeStyleCombo = new EnumCombo<>(FormatStyle.class,
         "Short", "Medium", "Long", "Full");

   public DateTimeFormatterFrame()
   {
      setLayout(new GridBagLayout());
      add(new JLabel("Locale"), new corejava.v2ch07.dateFormat.GBC(0, 0).setAnchor(corejava.v2ch07.dateFormat.GBC.EAST));
      add(localeCombo, new corejava.v2ch07.dateFormat.GBC(1, 0, 2, 1).setAnchor(corejava.v2ch07.dateFormat.GBC.WEST));
      
      add(new JLabel("Date"), new corejava.v2ch07.dateFormat.GBC(0, 1).setAnchor(corejava.v2ch07.dateFormat.GBC.EAST));
      add(dateStyleCombo, new corejava.v2ch07.dateFormat.GBC(1, 1).setAnchor(corejava.v2ch07.dateFormat.GBC.WEST));
      add(dateText, new corejava.v2ch07.dateFormat.GBC(2, 1, 2, 1).setFill(corejava.v2ch07.dateFormat.GBC.HORIZONTAL));
      add(dateParseButton, new corejava.v2ch07.dateFormat.GBC(4, 1).setAnchor(corejava.v2ch07.dateFormat.GBC.WEST));

      add(new JLabel("Time"), new corejava.v2ch07.dateFormat.GBC(0, 2).setAnchor(corejava.v2ch07.dateFormat.GBC.EAST));
      add(timeStyleCombo, new corejava.v2ch07.dateFormat.GBC(1, 2).setAnchor(corejava.v2ch07.dateFormat.GBC.WEST));
      add(timeText, new corejava.v2ch07.dateFormat.GBC(2, 2, 2, 1).setFill(corejava.v2ch07.dateFormat.GBC.HORIZONTAL));
      add(timeParseButton, new corejava.v2ch07.dateFormat.GBC(4, 2).setAnchor(corejava.v2ch07.dateFormat.GBC.WEST));

      add(new JLabel("Date and time"), new corejava.v2ch07.dateFormat.GBC(0, 3).setAnchor(corejava.v2ch07.dateFormat.GBC.EAST));
      add(dateTimeStyleCombo, new corejava.v2ch07.dateFormat.GBC(1, 3).setAnchor(corejava.v2ch07.dateFormat.GBC.WEST));
      add(dateTimeText, new corejava.v2ch07.dateFormat.GBC(2, 3, 2, 1).setFill(corejava.v2ch07.dateFormat.GBC.HORIZONTAL));
      add(dateTimeParseButton, new corejava.v2ch07.dateFormat.GBC(4, 3).setAnchor(GBC.WEST));

      locales = (Locale[]) Locale.getAvailableLocales().clone();
      Arrays.sort(locales, Comparator.comparing(Locale::getDisplayName));
      for (Locale loc : locales)
         localeCombo.addItem(loc.getDisplayName());
      localeCombo.setSelectedItem(Locale.getDefault().getDisplayName());
      currentDate = LocalDate.now();
      currentTime = LocalTime.now();
      currentDateTime = ZonedDateTime.now();
      updateDisplay();

      ActionListener listener = event -> updateDisplay();

      localeCombo.addActionListener(listener);
      dateStyleCombo.addActionListener(listener);
      timeStyleCombo.addActionListener(listener);
      dateTimeStyleCombo.addActionListener(listener);

      dateParseButton.addActionListener(event ->
         {
            String d = dateText.getText().trim();
            try
            {
               currentDate = LocalDate.parse(d, currentDateFormat);
               updateDisplay();
            }
            catch (Exception e)
            {
               dateText.setText(e.getMessage());
            }
         });

      timeParseButton.addActionListener(event -> 
         {
            String t = timeText.getText().trim();
            try
            {
               currentTime = LocalTime.parse(t, currentTimeFormat);
               updateDisplay();
            }
            catch (Exception e)
            {
               timeText.setText(e.getMessage());
            }
         });

      dateTimeParseButton.addActionListener(event -> 
      {
         String t = dateTimeText.getText().trim();
         try
         {
            currentDateTime = ZonedDateTime.parse(t, currentDateTimeFormat);
            updateDisplay();
         }
         catch (Exception e)
         {
            dateTimeText.setText(e.getMessage());
         }
      });

      pack();
   }

   /**
    * Updates the display and formats the date according to the user settings.
    */
   public void updateDisplay()
   {
      Locale currentLocale = locales[localeCombo.getSelectedIndex()];
      FormatStyle dateStyle = dateStyleCombo.getValue();
      currentDateFormat = DateTimeFormatter.ofLocalizedDate(
         dateStyle).withLocale(currentLocale);
      dateText.setText(currentDateFormat.format(currentDate));
      FormatStyle timeStyle = timeStyleCombo.getValue();
      currentTimeFormat = DateTimeFormatter.ofLocalizedTime(
         timeStyle).withLocale(currentLocale);
      timeText.setText(currentTimeFormat.format(currentTime));
      FormatStyle dateTimeStyle = dateTimeStyleCombo.getValue();
      currentDateTimeFormat = DateTimeFormatter.ofLocalizedDateTime(
         dateTimeStyle).withLocale(currentLocale);
      dateTimeText.setText(currentDateTimeFormat.format(currentDateTime));
   }
}

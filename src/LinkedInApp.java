import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkedInApp {
    private JFrame frame;
    private JPanel cards; // Kartları tutacak panel
    private final static String PROFILEPANEL = "Kullanıcı Profili";
    private final static String JOBPANEL = "İş ve Kariyer";
    private final static String SEARCHPANEL = "Arama ve Filtreleme";

    public LinkedInApp() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("LinkedIn Benzeri Uygulama");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        cards = new JPanel(new CardLayout());
        cards.add(createUserProfilePanel(), PROFILEPANEL);
        cards.add(createJobAndCareerPanel(), JOBPANEL);
        cards.add(createSearchAndFilteringPanel(), SEARCHPANEL);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu navigateMenu = new JMenu("Gezin");
        menuBar.add(navigateMenu);

        JMenuItem profileMenuItem = new JMenuItem(PROFILEPANEL);
        profileMenuItem.addActionListener(e -> showCard(PROFILEPANEL));
        navigateMenu.add(profileMenuItem);

        JMenuItem jobMenuItem = new JMenuItem(JOBPANEL);
        jobMenuItem.addActionListener(e -> showCard(JOBPANEL));
        navigateMenu.add(jobMenuItem);

        JMenuItem searchMenuItem = new JMenuItem(SEARCHPANEL);
        searchMenuItem.addActionListener(e -> showCard(SEARCHPANEL));
        navigateMenu.add(searchMenuItem);

        frame.add(cards, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void showCard(String card) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, card);
    }

    private JPanel createUserProfilePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Profil Bilgileri"));

        JPanel nameEmailPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        nameEmailPanel.add(new JLabel("Ad:"));
        JTextField nameField = new JTextField();
        nameEmailPanel.add(nameField);
        nameEmailPanel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        nameEmailPanel.add(emailField);
        panel.add(nameEmailPanel);

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BorderLayout());
        descriptionPanel.add(new JLabel("Profil Açıklaması:"), BorderLayout.NORTH);
        JTextArea descriptionArea = new JTextArea(5, 20);
        descriptionPanel.add(new JScrollPane(descriptionArea), BorderLayout.CENTER);
        panel.add(descriptionPanel);

        JPanel photoPanel = new JPanel();
        JButton uploadButton = new JButton("Profil Fotoğrafı Yükle");
        photoPanel.add(uploadButton);
        panel.add(photoPanel);

        JButton saveButton = new JButton("Bilgileri Kaydet");
        panel.add(saveButton);

        return panel;
    }

    private JPanel createJobAndCareerPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("İş ve Kariyer Fırsatları"));

        DefaultListModel<String> model = new DefaultListModel<>();
        String[] jobs = {"Yazılım Mühendisi", "Veri Analisti", "Ürün Yöneticisi", "Proje Yöneticisi",
                         "Pazarlama Müdürü", "Grafik Tasarımcı", "Sistem Analisti", "Ağ Mühendisi",
                         "Müşteri Hizmetleri Temsilcisi", "İnsan Kaynakları Uzmanı", "Satış Danışmanı", 
                         "Finans Müdürü", "Hukuk Danışmanı", "Mimar", "İnşaat Mühendisi"};
        for (String job : jobs) {
            model.addElement(job);
        }
        JList<String> jobList = new JList<>(model);
        panel.add(new JScrollPane(jobList), BorderLayout.CENTER);

        JButton applyButton = new JButton("Başvur");
        panel.add(applyButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createSearchAndFilteringPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Arama ve Filtreleme"));

        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("İş Kategorisi:"));
        JComboBox<String> categoryComboBox = new JComboBox<>(new String[]{"Hepsi", "Mühendislik", "Tıp", "Eğitim", "İdari", "Diğer"});
        filterPanel.add(categoryComboBox);
        panel.add(filterPanel);

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Arama Terimi:"));
        JTextField searchField = new JTextField(20);
        searchPanel.add(searchField);
        JButton searchButton = new JButton("Ara");
        searchPanel.add(searchButton);
        panel.add(searchPanel);

        DefaultListModel<String> searchResultsModel = new DefaultListModel<>();
        JList<String> searchResultsList = new JList<>(searchResultsModel);
        panel.add(new JScrollPane(searchResultsList));

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LinkedInApp());
    }
}

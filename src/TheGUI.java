import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TheGUI extends Application
{
	Stage window;
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		window = primaryStage;
		window.setTitle("Song Search");
		window.setResizable(false);
		
		Image img = new Image("musicBackground.jpg");
		ImageView imgView = new ImageView(img);
		Text text = new Text("Song Search");
		text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 50));
		
	    StackPane pane = new StackPane();
	    pane.getChildren().add(imgView);
	    pane.getChildren().add(text);
	    pane.setAlignment(Pos.CENTER);
		
		HBox imgHBox = new HBox(10);
		imgHBox.setPrefHeight(200);
		imgHBox.setPrefWidth(380);
		imgHBox.getChildren().add(pane);
		
		Button browse = new Button("Browse");
		
		Label artistLabel = new Label("Artist");
		Label titleLabel = new Label("Title");
		Label wordsLabel = new Label("Lyrics Words");
		Label phraseLabel = new Label("Lyrics Phrase");
		
		artistLabel.setPrefWidth(92);
		artistLabel.setAlignment(Pos.CENTER_RIGHT);
		titleLabel.setPrefWidth(92);
		titleLabel.setAlignment(Pos.CENTER_RIGHT);
		wordsLabel.setPrefWidth(100);
		wordsLabel.setAlignment(Pos.CENTER_RIGHT);
		phraseLabel.setPrefWidth(100);
		phraseLabel.setAlignment(Pos.CENTER_RIGHT);
		
		TextField artistText = new TextField();
		TextField titleText = new TextField();
		TextField wordsText = new TextField();
		TextField phraseText = new TextField();

		Button artistSearch = new Button("Search");
		Button titleSearch = new Button("Search");
		Button wordsSearch = new Button("Search");
		Button phraseSearch = new Button("Search");
		
		Label resultsLabel = new Label("Search Results");
		TableView<Song> resultsTable = buildSongTable();
				
		VBox resultsTableBox = new VBox(10);
		resultsTableBox.getChildren().addAll(resultsLabel, resultsTable);
		
		Label lyricsResultsLabel = new Label("Lyrics");
		TextArea lyricsResults = new TextArea();
		lyricsResults.setMinHeight(250);

		VBox lyricsResultsBox = new VBox(10);
		lyricsResultsBox.getChildren().addAll(lyricsResultsLabel, lyricsResults);
		
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
	
		grid.add(imgHBox, 0, 0);
		grid.add(browse, 0, 1);
		grid.add(addHBox(artistLabel, artistText, artistSearch), 0, 2);
		grid.add(addHBox(titleLabel, titleText, titleSearch), 0, 3);
		grid.add(addHBox(wordsLabel, wordsText, wordsSearch), 0, 4);
		grid.add(addHBox(phraseLabel, phraseText, phraseSearch), 0, 5);
		
		grid.add(resultsTableBox, 0, 6);
		grid.add(lyricsResultsBox, 0, 7);
		
		Scene scene = new Scene(grid, 455, 800);
		window.setScene(scene);
		window.show();
	}
	
	@SuppressWarnings("unchecked")
	public TableView<Song> buildSongTable()
	{
		TableView<Song> resultsTable = new TableView<>();
		
		TableColumn<Song, String> artistColumn = new TableColumn<>("Artist");
		artistColumn.setMinWidth(100);
		artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
		
		TableColumn<Song, String> titleColumn = new TableColumn<>("Title");
		titleColumn.setMinWidth(100);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

		TableColumn<Song, String> lyricsColumn = new TableColumn<>("Lyrics");
		lyricsColumn.setMinWidth(100);
		lyricsColumn.setCellValueFactory(new PropertyValueFactory<>("lyrics"));
		
		resultsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		resultsTable.setMaxHeight(230);
		resultsTable.setItems(getSongs());
		resultsTable.getColumns().addAll(artistColumn, titleColumn, lyricsColumn);
		
		return resultsTable;
	}

	/**
	 * Currently just returns a dummy list of <code>Song</code>s to display in the GUI
	 * @return the list of <code>Song</code>s
	 */
	public ObservableList<Song> getSongs()
	{
		ObservableList<Song> songs = FXCollections.observableArrayList();
		
		songs.add(new Song("The Beatles", "Hey Jude", ""));
		songs.add(new Song("The Beatles", "I Am The Walrus", ""));
		songs.add(new Song("The Rolling Stones", "Start Me Up", ""));
		songs.add(new Song("The Rolling Stones", "Gimmie Shelter", ""));
		songs.add(new Song("Rush", "2112", ""));
		songs.add(new Song("Rush", "Xanadu", ""));
		songs.add(new Song("Radiohead", "Pyramid Song", ""));
		songs.add(new Song("Radiohead", "Paranoid Android", ""));
		songs.add(new Song("David Bowie", "Ziggy Stardust", ""));
		songs.add(new Song("David Bowie", "Starman", ""));
		
		songs.sort(new SongComparator());

		return songs;
	}
	
	public HBox addHBox(Label label, TextField textField, Button button)
	{
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(5, 5, 5, 5));
		hbox.getChildren().add(label);
		hbox.getChildren().add(textField);
		hbox.getChildren().add(button);
		
		return hbox;
	}
}

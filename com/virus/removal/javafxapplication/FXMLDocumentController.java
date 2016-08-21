/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virus.removal.javafxapplication;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import com.virus.removal.cache.VirusCache;
import com.virus.removal.constants.VirusScanStatus;
import com.virus.removal.handler.VirusREMHandler;
import com.virus.removal.registry.RegistryKeyManager;
import com.virus.removal.registry.VirusRegistry;

/**
 *
 * @author cgopi
 */
public class FXMLDocumentController implements Initializable {

	private VirusREMHandler handler = null;

	private Task<Void> workerThread;

	/* Images */
	@FXML
	private ImageView imageview;
	@FXML
	private ImageView imageview1;
	
	/* Buttons */
	@FXML
	private Button b1;
	@FXML
	private Button b2;
	@FXML
	private Button b3;
	@FXML
	private Button b4;
	@FXML
	private Button scan;
	@FXML
	private Button b5;
	@FXML
	private Button b6;
	@FXML
	private Button w;
	@FXML
	private Button e;
	@FXML
	private Button r;
	@FXML
	private Button t;
	@FXML
	private Button y;
	@FXML
	private Button q;
	@FXML
	private Button max;
	@FXML
	private Button min;
	@FXML
	private Button u;
	@FXML
	private Button i;
	@FXML
	private Button clearHistory;
	
	/* Labels */
	@FXML
	private Label c1;
	@FXML
	private Label c2;
	@FXML
	private Label c3;
	@FXML
	private Label c4;
	@FXML
	private Label statusVal;
	@FXML
	private Label lastScanVal;
	@FXML
	private Label buildVal;
	@FXML
	private Label textValForJobStatus;
	@FXML
	private Label textValForPcName;
	@FXML
	private Label textValForThreatsFound;
	
	/* Pane */
	@FXML
	private Pane panel;
	@FXML
	private Pane top;
	@FXML
	private Pane about;
	@FXML
	private Pane dash;
	@FXML
	private Pane scann;
	@FXML
	private Pane his;
	@FXML
	private Pane update;
	@FXML
	private Pane general;
	@FXML
	private Pane unprotected;
	@FXML
	private Pane top1;
	@FXML
	private Pane isProtected;
	@FXML
	private Pane top11;

	/* Anchor Pane */
	@FXML
	private AnchorPane dropdown;

	/* TextArea */
	@FXML
	private TextArea txt;
	@FXML
	private TextArea textArea;
	@FXML
	private TextArea textForScanInProgress;
	@FXML
	private TextArea textAreaForHistory;
	
	/* Text */
	@FXML
	private Text textForThreats;
	@FXML
	private Text textForScanning;
	@FXML
	private Text virusScanning;
	@FXML
	private Text textForJobStatusInHistory;
	@FXML
	private Text textForPcNameInHistory;
	@FXML
	private Text textForThreatsFoundInHistory;
	@FXML
	private Text textForLastScanHistory;

	/* Menu Button */
	@FXML
	private MenuButton drop;
	
	/* Progress Bar */
	@FXML
	private ProgressBar progressBar;

	private VirusRegistry virusRegistry;
	private VirusCache virusCache;
	private RegistryKeyManager rkm;

	private List<String> virusSearchList = new ArrayList<String>();
	private Set<String> viruses = new HashSet<String>();

	private String timestamp = null;
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss a");
	
	private static final String REGISTRY_KEY_MANEGER_EMPTY = "Registry key manager is empty";

	private int progressCount = 1;
	
	private boolean isScanCancelled = false;

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(final URL url, final ResourceBundle rb) {

		dash.setVisible(false);
		scann.setVisible(false);
		about.setVisible(false);
		his.setVisible(false);
		update.setVisible(false);
		general.setVisible(false);
		isProtected.setVisible(false);
		unprotected.setVisible(true);
		
		handler = VirusREMHandler.getInstance();
		virusRegistry = VirusRegistry.getInstance();
		rkm = RegistryKeyManager.getInstance();
		virusCache = VirusCache.instance;
	}

	/**
	 * @param event
	 */
	@FXML
	private void b1(final ActionEvent event) {

		c2.setStyle("-fx-background-color:#DF4444");
		b1.setStyle("-fx-background-color:#373E48");

		c1.setStyle("-fx-background-color:transparent");
		b2.setStyle("-fx-background-color:transparent");

		c3.setStyle("-fx-background-color:transparent");
		b3.setStyle("-fx-background-color:transparent");

		c4.setStyle("-fx-background-color:transparent");
		b4.setStyle("-fx-background-color:transparent");

		b5.setStyle("-fx-background-color:transparent");
		b6.setStyle("-fx-background-color:transparent");

		dash.setVisible(false);
		dash.setManaged(false);

		scann.setVisible(false);
		scann.setManaged(false);

		isProtected.setVisible(false);
		isProtected.setManaged(false);

		unprotected.setVisible(true);
		unprotected.setManaged(true);

		about.setVisible(false);
		about.setManaged(false);

		his.setVisible(false);
		his.setManaged(false);

		update.setVisible(false);
		update.setManaged(false);

		general.setVisible(false);
		general.setManaged(false);
		
	}

	/**
	 * @param event
	 */
	@FXML
	private void b2(final ActionEvent event) {

		c1.setStyle("-fx-background-color:#DF4444");
		b2.setStyle("-fx-background-color:#373E48");

		c2.setStyle("-fx-background-color:transparent");
		b1.setStyle("-fx-background-color:transparent");

		c3.setStyle("-fx-background-color:transparent");
		b3.setStyle("-fx-background-color:transparent");

		c4.setStyle("-fx-background-color:transparent");
		b4.setStyle("-fx-background-color:transparent");

		b5.setStyle("-fx-background-color:transparent");
		b6.setStyle("-fx-background-color:transparent");

		unprotected.setVisible(false);
		unprotected.setManaged(false);

		scann.setManaged(false);
		scann.setVisible(false);

		isProtected.setVisible(false);
		isProtected.setManaged(false);

		dash.setVisible(true);
		dash.setManaged(true);

		about.setVisible(false);
		about.setManaged(false);

		his.setVisible(false);
		his.setManaged(false);

		update.setVisible(false);
		update.setManaged(false);

		general.setVisible(false);
		general.setManaged(false);

		javafx.application.Platform.runLater(new Runnable() {
			
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				buildVal.setText("01.01.058");
				
				if (handler.getVirusScanStatus() == VirusScanStatus.VIRUS_SCAN_STOPPED) {
					statusVal.setText("Potentially Unprotected");
					lastScanVal.setText(timestamp);
				}
			}
		});

	}

	/**
	 * @param event
	 */
	@FXML
	private void b3(final ActionEvent event) {

		c3.setStyle("-fx-background-color:#DF4444");
		b3.setStyle("-fx-background-color:#373E48");

		c1.setStyle("-fx-background-color:transparent");
		b1.setStyle("-fx-background-color:transparent");

		c2.setStyle("-fx-background-color:transparent");
		b2.setStyle("-fx-background-color:transparent");

		c4.setStyle("-fx-background-color:transparent");
		b4.setStyle("-fx-background-color:transparent");

		b5.setStyle("-fx-background-color:transparent");
		b6.setStyle("-fx-background-color:transparent");

		his.setVisible(true);
		his.setManaged(true);

		isProtected.setVisible(false);
		isProtected.setManaged(false);

		scann.setVisible(false);
		scann.setManaged(false);

		dash.setVisible(false);
		dash.setManaged(false);

		about.setVisible(false);
		about.setManaged(false);

		update.setVisible(false);
		update.setManaged(false);

		general.setVisible(false);
		general.setManaged(false);

		unprotected.setVisible(false);
		unprotected.setManaged(false);
		
		javafx.application.Platform.runLater(new Runnable() {
			
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				textValForPcName.setText(System.getenv("COMPUTERNAME"));
				
				if (handler.getVirusScanStatus() == VirusScanStatus.VIRUS_SCAN_STOPPED) {
					textValForJobStatus.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
					textValForJobStatus.setText("FAILED");
					
					textForLastScanHistory.setText("Last Scan: "+timestamp);
				}
			}
		});
		
	}

	/**
	 * @param event
	 */
	@FXML
	private void b4(final ActionEvent event) {

		c4.setStyle("-fx-background-color: transparent");
		b4.setStyle("-fx-background-color:#373E48");

		b5.setStyle("-fx-background-color:transparent");
		b6.setStyle("-fx-background-color:transparent");

		c2.setStyle("-fx-background-color:transparent");
		b2.setStyle("-fx-background-color:transparent");

		c3.setStyle("-fx-background-color:transparent");
		b3.setStyle("-fx-background-color:transparent");

		c1.setStyle("-fx-background-color:transparent");
		b1.setStyle("-fx-background-color:transparent");

		about.setVisible(true);
		about.setManaged(true);

		isProtected.setVisible(false);
		isProtected.setManaged(false);

		scann.setVisible(false);
		scann.setManaged(false);

		dash.setVisible(false);
		dash.setManaged(false);

		his.setVisible(false);
		his.setManaged(false);

		update.setVisible(false);
		update.setManaged(false);

		general.setVisible(false);
		general.setManaged(false);

		unprotected.setVisible(false);
		unprotected.setManaged(false);

	}

	int xOffset;
	int yOffset;

	/**
	 * @param event
	 */
	@FXML
	private void mouseDrag(final MouseEvent event) {
		JavaFXApplication.primaryStage.setX(event.getScreenX() + xOffset);
		JavaFXApplication.primaryStage.setY(event.getScreenY() + yOffset);
	}

	/**
	 * @param event
	 */
	@FXML
	private void mousePress(final MouseEvent event) {
		xOffset = (int) (JavaFXApplication.primaryStage.getX() - event.getScreenX());
		yOffset = (int) (JavaFXApplication.primaryStage.getY() - event.getScreenY());
	}

	/**
	 * @param event
	 */
	@FXML
	private void scanMouseExited(final MouseEvent event) {

	}

	/**
	 * @param event
	 */
	@FXML
	private void scanMouseEntered(final MouseEvent event) {

	}

	/**
	 * @param event
	 */
	@FXML
	private void close(final MouseEvent event) {
		System.exit(5);
	}

	/**
	 * @param event
	 */
	@FXML
	private void minimizee(final MouseEvent event) {
		JavaFXApplication.primaryStage.setIconified(true);
	}

	/**
	 * @param event
	 */
	@FXML
	private void b6(final ActionEvent event) {

		b6.setStyle("-fx-background-color:#373E48");
		b5.setStyle("-fx-background-color:transparent");

		c4.setStyle("-fx-background-color:transparent");
		b4.setStyle("-fx-background-color:transparent");

		c2.setStyle("-fx-background-color:transparent");
		b2.setStyle("-fx-background-color:transparent");

		c3.setStyle("-fx-background-color:transparent");
		b3.setStyle("-fx-background-color:transparent");

		c1.setStyle("-fx-background-color:transparent");
		b1.setStyle("-fx-background-color:transparent");

		update.setVisible(true);
		update.setManaged(true);

		isProtected.setVisible(false);
		isProtected.setManaged(false);

		scann.setVisible(false);
		scann.setManaged(false);

		dash.setVisible(false);
		dash.setManaged(false);

		his.setVisible(false);
		his.setManaged(false);

		about.setVisible(false);
		about.setManaged(false);

		general.setVisible(false);
		general.setManaged(false);

		unprotected.setVisible(false);
		unprotected.setManaged(false);

	}

	/**
	 * @param event
	 */
	@FXML
	private void b5(final ActionEvent event) {

		b5.setStyle("-fx-background-color:#373E48");

		b6.setStyle("-fx-background-color:transparent");

		c4.setStyle("-fx-background-color:transparent");
		b4.setStyle("-fx-background-color:transparent");

		c2.setStyle("-fx-background-color:transparent");
		b2.setStyle("-fx-background-color:transparent");

		c3.setStyle("-fx-background-color:transparent");
		b3.setStyle("-fx-background-color:transparent");

		c1.setStyle("-fx-background-color:transparent");
		b1.setStyle("-fx-background-color:transparent");

		general.setVisible(true);
		general.setManaged(true);

		isProtected.setVisible(false);
		isProtected.setManaged(false);

		scann.setVisible(false);
		scann.setManaged(false);

		dash.setVisible(false);
		dash.setManaged(false);

		his.setVisible(false);
		his.setManaged(false);

		about.setVisible(false);
		about.setManaged(false);

		update.setVisible(false);
		update.setManaged(false);

		unprotected.setVisible(false);
		unprotected.setManaged(false);
	}

	/**
	 * @param event
	 */
	@FXML
	private void scanningPressed(final ActionEvent event) {

		/* Set the status of virus scanning */
		handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STARTED);

		/* Clear the text */
		if (textForScanInProgress != null && textForScanInProgress.getText() != null) {
			textForScanInProgress.clear();
			javafx.application.Platform.runLater(new Runnable() {
			
				/* (non-Javadoc)
				 * @see java.lang.Runnable#run()
				 */
				@Override
				public void run() {
					/* Set the text */
					textForScanInProgress.appendText("Virus scanning is started"); 					
				}
			});
		}

		/* Set the style */
		b5.setStyle("-fx-background-color:transparent");
		b6.setStyle("-fx-background-color:transparent");

		c4.setStyle("-fx-background-color:transparent");
		b4.setStyle("-fx-background-color:transparent");

		c2.setStyle("-fx-background-color:#00AEEF");
		b2.setStyle("-fx-background-color:transparent");

		c3.setStyle("-fx-background-color:transparent");
		b3.setStyle("-fx-background-color:transparent");

		c1.setStyle("-fx-background-color:transparent");
		b1.setStyle("-fx-background-color:#373E48");

		general.setVisible(false);
		general.setManaged(false);

		scann.setVisible(true);
		scann.setManaged(true);

		isProtected.setVisible(false);
		isProtected.setManaged(false);

		dash.setVisible(false);
		dash.setManaged(false);

		his.setVisible(false);
		his.setManaged(false);

		about.setVisible(false);
		about.setManaged(false);

		update.setVisible(false);
		update.setManaged(false);

		unprotected.setVisible(false);
		unprotected.setManaged(false);

		/* Create the task to start scan operation */
		workerThread = createWorker();

		progressBar.progressProperty().unbind();
		progressBar.progressProperty().bind(workerThread.progressProperty());

		/* Start the thread */
		Thread thread = new Thread(workerThread);
		thread.setDaemon(true);
		thread.start();
		
	}
	
	/**
	 * @param event
	 */
	@FXML
	private void scanNowPressed(final ActionEvent event) {
		
		/* Set the style */
		b5.setStyle("-fx-background-color:transparent");
		b6.setStyle("-fx-background-color:transparent");

		c4.setStyle("-fx-background-color:transparent");
		b4.setStyle("-fx-background-color:transparent");

		c2.setStyle("-fx-background-color:#00AEEF");
		b2.setStyle("-fx-background-color:transparent");

		c3.setStyle("-fx-background-color:transparent");
		b3.setStyle("-fx-background-color:transparent");

		c1.setStyle("-fx-background-color:transparent");
		b1.setStyle("-fx-background-color:#373E48");

		general.setVisible(false);
		general.setManaged(false);

		scann.setVisible(true);
		scann.setManaged(true);

		isProtected.setVisible(false);
		isProtected.setManaged(false);

		dash.setVisible(false);
		dash.setManaged(false);

		his.setVisible(false);
		his.setManaged(false);

		about.setVisible(false);
		about.setManaged(false);

		update.setVisible(false);
		update.setManaged(false);

		unprotected.setVisible(false);
		unprotected.setManaged(false);
		
		if (workerThread == null 
				|| VirusScanStatus.VIRUS_JOB_COMPLETED == handler.getVirusScanStatus()
				|| VirusScanStatus.VIRUS_SCAN_STOPPED == handler.getVirusScanStatus()) {
			
			/* Create the task to start scan operation */
			workerThread = createWorker();

			progressBar.progressProperty().unbind();
			progressBar.progressProperty().bind(workerThread.progressProperty());

			/* Set the status of virus scanning */
			handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STARTED);
			
			/* Clear the text */
			if (textForScanInProgress != null && textForScanInProgress.getText() != null) {
				textForScanInProgress.clear();
				javafx.application.Platform.runLater(new Runnable() {
				
					/* (non-Javadoc)
					 * @see java.lang.Runnable#run()
					 */
					@Override
					public void run() {
						/* Set the text */
						textForScanInProgress.appendText("Virus scanning is started"); 					
					}
				});
			}
			
			/* Start the thread */
			Thread thread = new Thread(workerThread);
			thread.setDaemon(true);
			thread.start();
		}

	}

	/**
	 * @return
	 */
	private Task<Void> createWorker() {
		return new Task<Void>() {
			
			/* (non-Javadoc)
			 * @see javafx.concurrent.Task#call()
			 */
			@Override
			protected Void call() throws Exception {

				/* Start the scanning of viruses. */
				//				virusDetectedMap = handler.startScanning(progressBar, 
				//														 textArea,
				//														 textForThreats,
				//														 virusScanning,
				//														 workerThread);

				javafx.application.Platform.runLater(new Runnable() {
					
					/* (non-Javadoc)
					 * @see java.lang.Runnable#run()
					 */
					@Override
					public void run() {
						/* Set the status to Scanning in Dashboard */
						statusVal.setText("Scanning");
					}
				});
				
				/* Start Scanning */
				int index = 1;
				boolean isNextVirus = false;

				final Calendar c = Calendar.getInstance();
				timestamp = simpleDateFormat.format(c.getTime());
				
				if (isScanCancelled) {
					isScanCancelled = false;
				}

				final Map<String, String> virusDetectedMap = new HashMap<String, String>();
				final List<String> detectedViruses = new ArrayList<String>();

				javafx.application.Platform.runLater(new Runnable() {
			
					/* (non-Javadoc)
					 * @see java.lang.Runnable#run()
					 */
					@Override
					public void run() {
						
						if (textArea != null) {
							textArea.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
							if (textArea.getText() != null && !textArea.getText().isEmpty()) {
								textArea.clear();
							}
						}
						
						if (virusScanning != null && !virusScanning.getText().isEmpty()) {
							virusScanning.setText("Scanning...");
						}
						
						progressBar.setTooltip(new Tooltip("Virus scan in progress"));

						if (textForThreats != null && textForThreats.getText() != null && !textForThreats.getText().isEmpty()) {
							textForThreats.setText("");
						}
					}
				});
				
				System.out.println("Scan in progress..!!");
				System.out.println();

				if(virusRegistry != null) {
					virusSearchList.clear();
					virusSearchList = virusRegistry.getVirusSearchList();
				}
				if(virusCache != null) {
					viruses = virusCache.getAllViruses();
				}
				if(rkm == null) {
					rkm = RegistryKeyManager.getInstance();
				}

				/* Wait for sometime */
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				javafx.application.Platform.runLater(new Runnable() {
					
					/* (non-Javadoc)
					 * @see java.lang.Runnable#run()
					 */
					@Override
					public void run() {
						textArea.appendText("Currently Scanning:");
						textArea.appendText("\n");
						textArea.appendText("----------------------");
						textArea.appendText("\n");
						
						/* Cancel the Scan */
						q.setOnMouseClicked(new EventHandler<Event>() {
							
							/**
							 * @param me
							 */
							@Override
							public void handle(Event me) {
								isScanCancelled = true;
							}
						});
					}
				});

				if (isScanCancelled) {
					handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STOPPED);
					return null;
				}
				
				for (final String virus : viruses) {
					
					/* Cancel the Scan */
					q.setOnMouseClicked(new EventHandler<Event>() {

						/**
						 * @param me
						 */
						@Override
						public void handle(Event me) {
							isScanCancelled = true;
						}
					});
					
					if (isScanCancelled) {
						handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STOPPED);
						return null;
					}
					
					if(rkm == null) {
						System.out.println("Scan is stopped due to: "+REGISTRY_KEY_MANEGER_EMPTY);
						handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STOPPED);
						return null;
					}

					if (isNextVirus) {
						javafx.application.Platform.runLater(new Runnable() {
					
							/* (non-Javadoc)
							 * @see java.lang.Runnable#run()
							 */
							@Override
							public void run() {
								textArea.appendText("\n\n");
							}
						});
					}

					javafx.application.Platform.runLater(new Runnable() {
						
						/* (non-Javadoc)
						 * @see java.lang.Runnable#run()
						 */
						@Override
						public void run() {
							textArea.appendText(virus);
							textArea.appendText("\n");
						}
					});

					for (final String virusSearchUsingReg : virusSearchList) {
						
						/* Cancel the Scan */
						q.setOnMouseClicked(new EventHandler<Event>() {

							/**
							 * @param me
							 */
							@Override
							public void handle(Event me) {
								isScanCancelled = true;
							}
						});
						
						if (isScanCancelled) {
							handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STOPPED);
							return null;
						}
						
						javafx.application.Platform.runLater(new Runnable() {
						
							/* (non-Javadoc)
							 * @see java.lang.Runnable#run()
							 */
							@Override
							public void run() {
								textArea.appendText("\n");
								textArea.appendText(virusSearchUsingReg);
							}
						});
					
						try {
							if(virus != null && !virus.isEmpty() && virusSearchUsingReg != null && !virusSearchUsingReg.isEmpty()) {
								if(rkm != null) {
									rkm.query(virusSearchUsingReg, virus);
									if(rkm.getKey() != null && !rkm.getKey().isEmpty()) {
						
										javafx.application.Platform.runLater(new Runnable() {
											
											/* (non-Javadoc)
											 * @see java.lang.Runnable#run()
											 */
											@Override
											public void run() {
												textArea.appendText("\n");
											}
										});
										
										detectedViruses.add(virusSearchUsingReg+"\\"+virus);
										System.out.println("Found the virus: "+virusSearchUsingReg+"\\"+virus);
										virusDetectedMap.put(String.valueOf(index++)+virusSearchUsingReg, virus);
									}
								} else {
									System.out.println("Scan is stopped due to: "+REGISTRY_KEY_MANEGER_EMPTY);
									handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STOPPED);
									return null;
								}
							} 
						} catch (final Exception e) {
							System.out.println("Failed to scan due to: "+e.getMessage());
							handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STOPPED);
							return null;
						}
						isNextVirus = true;
					}

				}

				System.out.println("Virus scanning is completed");
				handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_COMPLETED);

				javafx.application.Platform.runLater(new Runnable() {
					
					/* (non-Javadoc)
					 * @see java.lang.Runnable#run()
					 */
					@Override
					public void run() {
						virusScanning.setText("");
					}
				});

				/* Cancel the Scan */
				q.setOnMouseClicked(new EventHandler<Event>() {

					/**
					 * @param me
					 */
					@Override
					public void handle(final Event me) {
						isScanCancelled = true;
					}
				});
				
				if (isScanCancelled) {
					handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STOPPED);
					return null;
				}

				final int noOfThreats = virusDetectedMap.size();
				
				javafx.application.Platform.runLater(new Runnable() {
					
					/* (non-Javadoc)
					 * @see java.lang.Runnable#run()
					 */
					@Override
					public void run() {
						textValForThreatsFound.setText(String.valueOf(noOfThreats));
					}
				});
				
				if (handler.getVirusScanStatus() == VirusScanStatus.VIRUS_SCAN_COMPLETED
												 && virusDetectedMap != null
												 && virusDetectedMap.size() > 0)  {

					javafx.application.Platform.runLater(new Runnable() {
					
						/* (non-Javadoc)
						 * @see java.lang.Runnable#run()
						 */
						@Override
						public void run() {
							textForThreats.setText("Found Threats: "+noOfThreats);
							textArea.appendText("\n\n");
							textArea.appendText("Found one or more viruses:");
							textArea.appendText("\n");
							textArea.appendText("--------------------------------");
							textArea.appendText("\n");
							for (final String detectedVirus : detectedViruses) {
								textArea.appendText(detectedVirus);
								textArea.appendText("\n");
							}
						}
					});

					/* Wait for sometime */
					try {
						Thread.sleep(5000);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} else {

					javafx.application.Platform.runLater(new Runnable() {
						
						/* (non-Javadoc)
						 * @see java.lang.Runnable#run()
						 */
						@Override
						public void run() {
							textForThreats.setText("Found Threats: "+noOfThreats);
							textArea.appendText("\n\n");
							textArea.appendText("No viruses are found");
						}
					});
					
					/* Update the progress */
					updateProgress(1, 1);
					
					/* Wait for sometime */
					try {
						Thread.sleep(3000);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}

				if (handler.getVirusScanStatus() == VirusScanStatus.VIRUS_SCAN_COMPLETED
												 && virusDetectedMap != null
												 && virusDetectedMap.size() > 0) {

					/* Delete the viruses found in scanning. */
					//					final boolean virusesDeleted = handler.deleteViruses(progressBar, 
					//																		 textArea,
					//																		 textForThreats,
					//																		 virusScanning);

					/* Start killing viruses */
					boolean areVirusesDeleted = false;

					javafx.application.Platform.runLater(new Runnable() {
						
						/* (non-Javadoc)
						 * @see java.lang.Runnable#run()
						 */
						@Override
						public void run() {
							textArea.appendText("\n\n");
							textArea.appendText("Killing:");
							textArea.appendText("\n");
							textArea.appendText("--------");
							textArea.appendText("\n");
						}
					});

					/* Cancel the Scan */
					q.setOnMouseClicked(new EventHandler<Event>() {

						/**
						 * @param me
						 */
						@Override
						public void handle(Event me) {
							isScanCancelled = true;
						}
					});
					
					if (isScanCancelled) {
						handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STOPPED);
						return null;
					}

					System.out.println("\n");
					for(final Map.Entry<String, String> virusEntry : virusDetectedMap.entrySet()) {
						try {
							if (rkm != null) {
								rkm.deleteKey(virusEntry.getKey().substring(1), virusEntry.getValue());
								javafx.application.Platform.runLater(new Runnable() {
						
									/* (non-Javadoc)
									 * @see java.lang.Runnable#run()
									 */
									@Override
									public void run() {
										textArea.appendText("Removed the virus: "+virusEntry.getKey().substring(1)+"\\"+virusEntry.getValue());
										virusScanning.setText("");
									}
								});
								System.out.println("Removed the virus: "+virusEntry.getKey().substring(1)+"\\"+virusEntry.getValue());
								areVirusesDeleted = true;
							} else {
								System.out.println("Scan is stopped due to: "+REGISTRY_KEY_MANEGER_EMPTY);
								handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STOPPED);
								return null;
							}
						} catch (Exception e) {
							System.out.println(e.getLocalizedMessage());
						}

						if (progressCount == virusDetectedMap.size()) {
							updateProgress(1, 1);
						}
						
						progressCount++;
					}
					
					/* Update the progress */
					updateProgress(1, 1);

					/* Wait for sometime */
					try {
						Thread.sleep(3000);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

					System.out.println();
					System.out.println("Virus removal is completed");
					
					if (virusDetectedMap != null) {
						virusDetectedMap.clear();
					}
					
					javafx.application.Platform.runLater(new Runnable() {

						/* (non-Javadoc)
						 * @see java.lang.Runnable#run()
						 */
						@Override
						public void run() {
							if (textForScanInProgress.getText() != null) {
								textForScanInProgress.clear();
							}
							textForScanInProgress.appendText("Virus scanning is completed");
						}
					});

					if (areVirusesDeleted) {
						b5.setStyle("-fx-background-color:transparent");
						b6.setStyle("-fx-background-color:transparent");
						c4.setStyle("-fx-background-color:transparent");
						b4.setStyle("-fx-background-color:transparent");
						c2.setStyle("-fx-background-color:#3FC639");
						b2.setStyle("-fx-background-color:transparent");
						c3.setStyle("-fx-background-color:transparent");
						b3.setStyle("-fx-background-color:transparent");
						c1.setStyle("-fx-background-color:transparent");
						b1.setStyle("-fx-background-color:#373E48");

						isProtected.setVisible(true);
						isProtected.setManaged(true);

						unprotected.setVisible(false);
						unprotected.setManaged(false);

						general.setVisible(false);
						general.setManaged(false);

						scann.setVisible(false);
						scann.setManaged(false);

						dash.setVisible(false);
						dash.setManaged(false);

						his.setVisible(false);
						his.setManaged(false);

						about.setVisible(false);
						about.setManaged(false);

						update.setVisible(false);
						update.setManaged(false);
						
						javafx.application.Platform.runLater(new Runnable() {
						
							/* (non-Javadoc)
							 * @see java.lang.Runnable#run()
							 */
							@Override
							public void run() {
								/* Set the status */
								statusVal.setText("Potentially Protected");
							}
						});
						
					} else {
						c2.setStyle("-fx-background-color:#DF4444");
						b1.setStyle("-fx-background-color:#373E48");
						c1.setStyle("-fx-background-color:transparent");
						b2.setStyle("-fx-background-color:transparent");
						c3.setStyle("-fx-background-color:transparent");
						b3.setStyle("-fx-background-color:transparent");
						c4.setStyle("-fx-background-color:transparent");
						b4.setStyle("-fx-background-color:transparent");
						b5.setStyle("-fx-background-color:transparent");
						b6.setStyle("-fx-background-color:transparent");

						unprotected.setVisible(true);
						unprotected.setManaged(true);

						isProtected.setVisible(false);
						isProtected.setManaged(false);

						general.setVisible(false);
						general.setManaged(false);

						scann.setVisible(false);
						scann.setManaged(false);

						dash.setVisible(false);
						dash.setManaged(false);

						his.setVisible(false);
						his.setManaged(false);

						about.setVisible(false);
						about.setManaged(false);

						update.setVisible(false);
						update.setManaged(false);
						
						javafx.application.Platform.runLater(new Runnable() {
							
							/* (non-Javadoc)
							 * @see java.lang.Runnable#run()
							 */
							@Override
							public void run() {
								/* Set the text */
								statusVal.setText("Potentially Unprotected");
							}
						});
					}
				} else if (handler.getVirusScanStatus() == VirusScanStatus.VIRUS_SCAN_COMPLETED) {

					javafx.application.Platform.runLater(new Runnable() {
						
						/* (non-Javadoc)
						 * @see java.lang.Runnable#run()
						 */
						@Override
						public void run() {
							if (textForScanInProgress.getText() != null) {
								textForScanInProgress.clear();
							}
							textForScanInProgress.appendText("Virus scanning is completed");
							statusVal.setText("Potentially Protected");
						}
					});

					b5.setStyle("-fx-background-color:transparent");
					b6.setStyle("-fx-background-color:transparent");
					c4.setStyle("-fx-background-color:transparent");
					b4.setStyle("-fx-background-color:transparent");
					c2.setStyle("-fx-background-color:#3FC639");
					b2.setStyle("-fx-background-color:transparent");
					c3.setStyle("-fx-background-color:transparent");
					b3.setStyle("-fx-background-color:transparent");
					c1.setStyle("-fx-background-color:transparent");
					b1.setStyle("-fx-background-color:#373E48");

					isProtected.setVisible(true);
					isProtected.setManaged(true);

					unprotected.setVisible(false);
					unprotected.setManaged(false);

					general.setVisible(false);
					general.setManaged(false);

					scann.setVisible(false);
					scann.setManaged(false);

					dash.setVisible(false);
					dash.setManaged(false);

					his.setVisible(false);
					his.setManaged(false);

					about.setVisible(false);
					about.setManaged(false);

					update.setVisible(false);
					update.setManaged(false);

					System.out.println("No viruses are found in scanning");
				}

				handler.setVirusScanStatus(VirusScanStatus.VIRUS_JOB_COMPLETED);
				
				
				javafx.application.Platform.runLater(new Runnable() {
					
					/* (non-Javadoc)
					 * @see java.lang.Runnable#run()
					 */
					@Override
					public void run() {

						statusVal.setFont(Font.font("Verdana", FontWeight.LIGHT, 10));
						lastScanVal.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
						buildVal.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
						
						/* Set the values like last-scan, build in Dashboard based on the virus scan results. */
						if (handler.getVirusScanStatus() == VirusScanStatus.VIRUS_JOB_COMPLETED) {
							
							lastScanVal.setText(timestamp);
							textForLastScanHistory.setText("Last Scan: "+timestamp);

							/* Job is successful */
							textValForJobStatus.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
							textValForJobStatus.setText("SUCCESSFUL");
						} else if (handler.getVirusScanStatus() == VirusScanStatus.VIRUS_SCAN_STOPPED) {

							statusVal.setText("Potentially Unprotected");
							lastScanVal.setText(timestamp);
							textForLastScanHistory.setText("Last Scan: "+timestamp);

							/* Job is failed */
							textValForJobStatus.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
							textValForJobStatus.setText("FAILED");
						}
					}
				});
				
				return null;
			}
		};
	}

	/**
	 * @param event
	 */
	@FXML
	private void notProtectedPressed(final ActionEvent event) {

		handler.setVirusScanStatus(VirusScanStatus.VIRUS_SCAN_STOPPED);

		if (workerThread != null && workerThread.isRunning()) {
			workerThread.cancel();
		}

		if (textArea != null && textArea.getText() != null && !textArea.getText().isEmpty()) {
			textArea.clear();
		}

		javafx.application.Platform.runLater(new Runnable() {
			
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				if (textForScanInProgress.getText() != null) {
					textForScanInProgress.clear();
				}
				textForScanInProgress.appendText("Virus scanning is stopped");
				statusVal.setText("Potentially Unprotected");
			}
		});
		
		handler.stopScanning();

		c2.setStyle("-fx-background-color:#DF4444");
		b1.setStyle("-fx-background-color:#373E48");

		c1.setStyle("-fx-background-color:transparent");
		b2.setStyle("-fx-background-color:transparent");

		c3.setStyle("-fx-background-color:transparent");
		b3.setStyle("-fx-background-color:transparent");

		c4.setStyle("-fx-background-color:transparent");
		b4.setStyle("-fx-background-color:transparent");

		b5.setStyle("-fx-background-color:transparent");
		b6.setStyle("-fx-background-color:transparent");

		//b2.setStyle("-fx-background-color:#373E48");

		//b1.setStyle("-fx-background-color:transparent");

		unprotected.setVisible(true);
		unprotected.setManaged(true);

		isProtected.setVisible(false);
		isProtected.setManaged(false);

		general.setVisible(false);
		general.setManaged(false);

		scann.setVisible(false);
		scann.setManaged(false);

		dash.setVisible(false);
		dash.setManaged(false);

		his.setVisible(false);
		his.setManaged(false);

		about.setVisible(false);
		about.setManaged(false);

		update.setVisible(false);
		update.setManaged(false);

	}

	/**
	 * @param event
	 */
	@FXML
	private void protectedPressed(final ActionEvent event) {

		b5.setStyle("-fx-background-color:transparent");

		b6.setStyle("-fx-background-color:transparent");

		c4.setStyle("-fx-background-color:transparent");
		b4.setStyle("-fx-background-color:transparent");

		c2.setStyle("-fx-background-color:#3FC639");
		b2.setStyle("-fx-background-color:#373E48");

		c3.setStyle("-fx-background-color:transparent");
		b3.setStyle("-fx-background-color:transparent");

		c1.setStyle("-fx-background-color:transparent");
		b1.setStyle("-fx-background-color:transparent");

		isProtected.setVisible(true);
		isProtected.setManaged(true);

		unprotected.setVisible(false);
		unprotected.setManaged(false);

		general.setVisible(false);
		general.setManaged(false);

		scann.setVisible(false);
		scann.setManaged(false);

		dash.setVisible(false);
		dash.setManaged(false);

		his.setVisible(false);
		his.setManaged(false);

		about.setVisible(false);
		about.setManaged(false);

		update.setVisible(false);
		update.setManaged(false);

	}
	
	/**
	 * @param event
	 */
	@FXML
	private void clearHistory(final ActionEvent event) {

		c3.setStyle("-fx-background-color:#DF4444");
		b3.setStyle("-fx-background-color:#373E48");

		c1.setStyle("-fx-background-color:transparent");
		b1.setStyle("-fx-background-color:transparent");

		c2.setStyle("-fx-background-color:transparent");
		b2.setStyle("-fx-background-color:transparent");

		c4.setStyle("-fx-background-color:transparent");
		b4.setStyle("-fx-background-color:transparent");

		b5.setStyle("-fx-background-color:transparent");
		b6.setStyle("-fx-background-color:transparent");

		his.setVisible(true);
		his.setManaged(true);

		isProtected.setVisible(false);
		isProtected.setManaged(false);

		scann.setVisible(false);
		scann.setManaged(false);

		dash.setVisible(false);
		dash.setManaged(false);

		about.setVisible(false);
		about.setManaged(false);

		update.setVisible(false);
		update.setManaged(false);

		general.setVisible(false);
		general.setManaged(false);

		unprotected.setVisible(false);
		unprotected.setManaged(false);
		
		javafx.application.Platform.runLater(new Runnable() {
		
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				textForLastScanHistory.setText("Last Scan: NO DATA");
				
				if (textValForJobStatus.getStyle() != null)  {
					textValForJobStatus.setStyle("");
				}
				textValForJobStatus.setText("NO DATA");
				textValForPcName.setText(System.getenv("COMPUTERNAME"));
				textValForThreatsFound.setText("NO DATA");
			}
		});
		
		clearHistory.setTooltip(new Tooltip("Clear the history"));
		
	}

	/**
	 * @param event
	 */
	@FXML
	private void ee(final ActionEvent event) {
		drop.setText("English");
		txt.setText("An important aspect of technology is its accessibility and moreover assurance that things will not go wrong, as everything which has to do with the technology industry and the ecosystem it has built, has grown phenomenally, so has the need for better security, more reliable interfaces, and optimal performance. Keeping just that in mind at VirusREM we’ve come up with the perfect product which caters to both the mass market of consumers and the niche requirements of corporations.");
	}

	/**
	 * @param event
	 */
	@FXML
	private void ss(final ActionEvent event) {
		drop.setText("Spanish");
		txt.setText("Un aspecto importante de la tecnología es su accesibilidad y garantía, además, que las cosas no van mal, como todo lo que tiene que ver con la industria de la tecnología y el ecosistema que ha construido, ha crecido enormemente, por lo que tiene la necesidad de mejorar la seguridad, las interfaces más fiables y un rendimiento óptimo. Mantener sólo eso en mente en VirusREM que hemos llegado con el producto perfecto, que atiende a las necesidades del mercado de masas de los consumidores y las necesidades de las empresas de nicho.");
	}

	/**
	 * @param event
	 */
	@FXML
	private void ff(final ActionEvent event) {
		drop.setText("French");
		txt.setText("Un aspect important de la technologie est son accessibilité et de l'assurance de plus que les choses ne vont pas aller mal, comme tout ce qui a à voir avec l'industrie de la technologie et de l'écosystème, il a construit, a connu une croissance phénoménale, a donc la nécessité d'une meilleure sécurité, interfaces plus fiables , et des performances optimales. Garder tout cela à l'esprit à VirusREM nous avons mis au point le produit parfait qui répond à la fois le marché de masse des consommateurs et les exigences de niche des sociétés.");
	}

	/**
	 * @param event
	 */
	@FXML
	private void gg(final ActionEvent event) {
		drop.setText("German");
		txt.setText("Ein wichtiger Aspekt der Technologie ist die Zugänglichkeit und darüber hinaus Sicherheit, dass die Dinge nicht schief gehen, wie alles, was mit der Technologie-Industrie zu tun hat und das Ökosystem es gebaut hat, ist phänomenal gewachsen, so die Notwendigkeit für eine bessere Sicherheit hat, zuverlässiger Schnittstellen und eine optimale Leistung. Halten Sie genau das im Sinn bei VirusREM haben wir mit dem perfekten Produkt kommen, die sowohl den Massenmarkt der Verbraucher richtet und die Nischen Anforderungen von Unternehmen.");
	}

	/**
	 * @param event
	 */
	@FXML
	private void pp(final ActionEvent event) {
		drop.setText("Portuguese");
		txt.setText("Um aspecto importante da tecnologia é a sua acessibilidade e garantia, além disso, que as coisas não vão dar errado, como tudo o que tem a ver com a indústria da tecnologia e do ecossistema que construiu, tem crescido fenomenalmente, tem assim a necessidade de uma melhor segurança, as interfaces mais fiáveis e um desempenho ideal. Mantendo apenas isso em mente o tempo VirusREM nós viemos acima com o produto perfeito, que serve tanto para o mercado de massa de consumidores e os requisitos de nicho de empresas.");
	}

}
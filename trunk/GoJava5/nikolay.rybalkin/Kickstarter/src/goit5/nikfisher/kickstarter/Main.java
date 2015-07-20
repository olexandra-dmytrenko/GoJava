package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;

import java.util.Arrays;

public class Main {

	private String SPACE = " ";
	private Categories    categories;
	private Projects projects;
	private InputOutputConsoleInterface io;
	private QuoteGenerate generator;

	public Main(Categories categories, Projects projects, InputOutputConsoleInterface io, QuoteGenerate generator) {

		this.categories = categories;
		this.projects = projects;
		this.io = io;
		this.generator = generator;
	}

	public void run() {

		io.println(generator.quoteGenerate());

		categoryMenu().runMenu();

		io.println("Thank you for using our service!");
	}

	private Menu categoryMenu() {

		return new Menu(io) {

			@Override
			public Menu nextMenu(Object selected) {
				Category category = (Category)selected;
				Project[] found = projects.getProgects(category);
				printProjects(found);

				return projectsMenu(found);
			}

			@Override
			public Object choose(int menuIndex) {
				return chooseCategory(menuIndex);
			}

			@Override
			public void ask() {
				askCategory();
			}
		};
	}

	private Menu projectsMenu(final Project[] found) {

		return new Menu(io) {

			@Override
			public Menu nextMenu(Object selected) {
				Project project = (Project)selected;
				printProjectDetail(project);
				projectMenu(project);
				return projectMenu(project);
			}

			@Override
			public Object choose(int menuIndex) {
				return chooseProjects(menuIndex, found);
			}

			@Override
			public void ask() {
				ascProjects(found);
			}
		};
	}

	private Menu projectMenu(Project project) {

		return new Menu(io) {

			@Override
			public Menu nextMenu(Object selected) {
				Integer menu = (Integer)selected;

				if (menu == 1){
					io.println("Thank you want to help!");
					int required_amount = project.getAmount();
					io.println("The required amount: " + String.valueOf(required_amount));

					io.println("1) If you invest up to 10% of the required amount, you will receive a 1% to 5%.");
					io.println("2) If you invest up to 50% of the required amount, you will receive a 5% to 15%.");
					io.println("3) If you invest up to 100% of the required amount, you will receive a 15% to 30%.");
					io.println("-----------------");
					io.println("Enter your name");
					String name = io.consoleScanString();
					io.println("Enter the number of your card");
					int cardNumber = io.consoleScanInt();
					io.println("Enter the amount of money");
					int amount = io.consoleScanInt();
					//TODO проверку наа вводимые значения
					//TODO зачислить деньги на счет проекта

					io.println("Thank you " + name + " your money is successfully transferred to the account of the project");
					io.println("---------------------------------------");

					project.donate((amount));
				}
				if (menu == 2){
					io.println("Enter your name");
					String name = io.consoleScanString();
					io.println("Enter your question");
					String question = io.consoleScanString();
					io.println("Thank you " + name + " for your question");
					io.println("---------------------------------------");

					project.question((question));
				}
				return null;
			}

			@Override
			public Object choose(int menuIndex) {
				return menuIndex;
			}

			@Override
			public void ask() {
				ascProject(project);
			}
		};
	}

	private void askCategory() {

		io.println(SPACE);
		io.println("Select category (or 0 to exit): ");
		io.println(Arrays.toString(categories.getCategories()));
	}

	private void ascProject(Project project) {
		io.println("Operations on the project: [0 - go to the list of projects, 1 - invest in the project, 2 - ask a Question]");
	}


	private void ascProjects(Project[] foundProjects) {

		if (foundProjects.length == 0 ){
			io.println("Projects in this category do not have to exit, enter 0");
		}else {
			int from = 0;
			int to = foundProjects.length - 1;
			io.println("Select project: [" + from + "..." +  to  + " or 0 for exit to the projects list]");
		}
	}

	private void printProjectDetail(Project project) {

		io.println("Project detail:");
		printProject(project);

		String history = project.getHistory();
		if (history != null){
			io.println(history);
		}

		String video = project.getVideo();
		if (video != null){
			io.println(video);
		}

		String question = project.getQuestion();
		if (question != null){
			io.println(question);
		}

		String ansver = project.getAnsver();
		if (ansver != null){
			io.println(ansver);
		}


		io.println("---------------------------------------");
	}

	private void printProjects(Project[] foundProjects) {

		for (int i = 0; i < foundProjects.length; i++) {
			Project project = foundProjects[i];
			io.print((i + 1) + ") ");
			printProject(project);
        }
	}

	private void printProject(Project project) {

		io.println("Project name: " + project.getName());
		io.println("Description: " + project.getDescription());
		io.println("Need collected: " + project.getAmount() + "$");
		io.println("Already collected: " + project.getExist() + "$");
		io.println("Days remaining: " + project.getDays());
		io.println("---------------------------------------");
		io.println(SPACE);
	}



	private Category chooseCategory(int categoryIndex) {

		if ( categoryIndex <= 0 || categories.size() < categoryIndex){
			io.println("Not true index: " + categoryIndex);
			return null;
		}

		Category category = categories.get(categoryIndex - 1);
		io.println("You selected category: " + category.getName());
		return category;
	}

	private Project chooseProjects(int projectMenuIndex, Project[] foundProjects){

		if (projectMenuIndex <= 0 || foundProjects.length <  projectMenuIndex){
			io.println("Not true index: " + projectMenuIndex);
			return null;
		}
		Project project = foundProjects[projectMenuIndex - 1];
		return project;
	}

	private void chooseProject(Project project) {

		io.println("You selected project: " + project.getName());
	}


}



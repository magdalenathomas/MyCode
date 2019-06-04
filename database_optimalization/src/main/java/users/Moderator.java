package users;

import repository.CompanyRepository;
import repository.model.CompanyEntity;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Moderator {
	CompanyRepository companyRepository = new CompanyRepository();

	ExecutorService executorService = Executors.newSingleThreadExecutor();

	public Moderator() {
	}

	public Future<Void> updateCity(final String oldName, final String newName, final int delay) {
		return executorService.submit(new Callable<Void>() {
			public Void call() throws Exception {
				Collection<CompanyEntity> allByCityName = companyRepository.findAllByCityName(oldName);
				System.out.println(allByCityName.size());
				System.out.println("Update city " + oldName + " " + newName);
				for (CompanyEntity companyEntity : allByCityName) {
					companyEntity.setCity(newName);
					Thread.sleep(delay);
					companyRepository.save(companyEntity);
				}
				return null;
			}
		});
	}
}

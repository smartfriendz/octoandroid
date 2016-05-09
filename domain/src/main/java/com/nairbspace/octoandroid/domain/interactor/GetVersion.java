package com.nairbspace.octoandroid.domain.interactor;

import com.nairbspace.octoandroid.domain.Printer;
import com.nairbspace.octoandroid.domain.executor.PostExecutionThread;
import com.nairbspace.octoandroid.domain.executor.ThreadExecutor;
import com.nairbspace.octoandroid.domain.repository.PrinterRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetVersion extends UseCase {

    private final PrinterRepository mPrinterRepository;
    private Printer mPrinter;

    @Inject
    public GetVersion(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                      PrinterRepository printerRepository) {
        super(threadExecutor, postExecutionThread);
        mPrinterRepository = printerRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mPrinterRepository.printerVersion(mPrinter);
    }

    public void setPrinter(Printer printer) {
        mPrinter = printer;
    }
}

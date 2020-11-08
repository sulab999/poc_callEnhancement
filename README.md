# poc_callEnhancement

my poc to com.qualcomm.qti.callenhancement.
1. Press the BindService Button , named of BINDSERVICE, to bind the target service named of com.qualcomm.qti.callenhancement.CallEnhancementService.
2. Check if there is a active telephone calls by the HASANYAVTIVECALL button.
3. If the result of step 2 shows true, we can start to record the telephone call by the start button. (If we don't record the telephone call at another app).
4. When the telephone call stops, the recording action will be stoped in the target app (not my poc). But we call stop recording ahead of time, by pressing the stop button.
5. We can get the recording file(.amr). Just press the storage button, named of the storage path of the target app.

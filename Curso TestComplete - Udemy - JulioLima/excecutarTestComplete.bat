IF EXIST C:\Users\NoteDELL\Documents\TestComplete 12 Projects\CursoAutomacaoDesktopTestComplete\Relatorios\relatorio.mht(
	del "C:\Users\NoteDELL\Documents\TestComplete 12 Projects\CursoAutomacaoDesktopTestComplete\Relatorios\relatorio.mht"   
	)
"C:\Program Files (x86)\SmartBear\TestComplete 12\x64\Bin\TestComplete.exe" "C:\Users\NoteDELL\Documents\TestComplete 12 Projects\CursoAutomacaoDesktopTestComplete\CursoAutomacaoDesktopTestComplete.pjs" /run /exit /ns /ExportLog:"C:\Users\NoteDELL\Documents\TestComplete 12 Projects\CursoAutomacaoDesktopTestComplete\Relatorios\relatorio.mht"
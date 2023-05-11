package view

import service.RootService
import tools.aqua.bgw.core.BoardGameApplication
import utils.Constants.WINDOW_TITLE

class SopraApplication : BoardGameApplication(WINDOW_TITLE), Refreshable {

	private val rootService = RootService()
	private val startScene = StartScene(rootService)
	private val gameScene = GameScene(rootService)

   init {
		rootService.addRefreshables(
			this,
			gameScene,
		)
		this.showMenuScene(startScene)
	}

	override fun refreshAfterGameStart() {
		this.hideMenuScene()
		this.showGameScene(gameScene)
	}
}


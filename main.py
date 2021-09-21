from realization.game_objects import player
import pygame

import realization
import config
import main_game_class

pygame.init()

field = realization.field.Field((config.FIELD_X_MAX, config.FIELD_Y_MAX))
player = realization.game_objects.Player(field, (0, 0))
realization.field.objects_on_field.ObjectOnField(field, (5, 5))

# main game
main_game = main_game_class.MainGame()
main_game.set_field(field)
main_game.set_player(player)

while True:
    pygame.time.delay(70)

    main_game.iteration()

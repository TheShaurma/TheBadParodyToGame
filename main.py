import pygame

import realization
import visualization

FIELD_X_MAX = 20
FIELD_Y_MAX = 20

WINDOW_X_MAX = 500
WINDOW_Y_MAX = 500

pygame.init()

field = realization.field.Field((FIELD_X_MAX, FIELD_Y_MAX))

v_field = visualization.showed_field.ShowedField(
    (WINDOW_X_MAX, WINDOW_Y_MAX), (FIELD_X_MAX, FIELD_Y_MAX)
)
v_field.set_field(field)
snake = realization.player.Player(field, (0, 0))
realization.field.objects_on_field.ObjectOnField(field, (5, 5))
checker = realization.mouse_keys_and_events_checker.checkers.Checker()

while True:
    pygame.time.delay(70)

    keys = pygame.key.get_pressed()

    if checker[realization.mouse_keys_and_events_checker.constants.K_DOWN]:
        try:
            snake.move_down()
        except realization.field.PositionError:
            pass
    if checker[realization.mouse_keys_and_events_checker.constants.K_RIGHT]:
        try:
            snake.move_right()
        except realization.field.PositionError:
            pass
    if checker[realization.mouse_keys_and_events_checker.constants.K_UP]:
        try:
            snake.move_up()
        except realization.field.PositionError:
            pass
    if checker[realization.mouse_keys_and_events_checker.constants.K_LEFT]:
        try:
            snake.move_left()
        except realization.field.PositionError:
            pass

    if checker[realization.mouse_keys_and_events_checker.constants.QUIT]:
        raise Exception()

    v_field.window_update()

class Keyboard:
    _instance = None
    keyboard = []

    def __init__(self):
        if Keyboard._instance is not None:
            print "Exists"
        else:
            Keyboard._instance = self

    @staticmethod
    def get_instance():
        if Keyboard._instance is None:
            Keyboard()
        return Keyboard._instance

    def register(self, button):
        self.keyboard.append(button)
        print "Button added: ", button.key

    def unregister(self, button):
        self.keyboard.remove(button)
        print "Button removed: ", button.key

    def notice(self, button):
        button.update()
        self.unregister(button)


class AbstractButton:

    def __init__(self):
        pass

    def update(self):
        pass


class Button(AbstractButton):

    def __init__(self, key):
        self.key = key

    def update(self):
        print "Button pushed: ", self.key


class DecoratedButton1(AbstractButton):

    def __init__(self, button):
        self.undec = button
        self.key = button.key

    def update(self):
        self.undec.update()
        print "!"


class DecoratedButton2(AbstractButton):

    def __init__(self, button):
        self.undec2 = button
        self.key = button.key

    def update(self):
        self.undec2.update()
        print "?"


keyboard = Keyboard()
print keyboard

s = Keyboard.get_instance()
print s

k1 = Button("a")
k2 = Button("b")
k3 = Button("c")
k4 = Button("d")
k5 = Button("e")
k6 = DecoratedButton1(k1)
k7 = DecoratedButton2(k2)


keyboard.register(k6)
keyboard.register(k7)
keyboard.register(k3)
keyboard.register(k4)
keyboard.register(k5)

print "Press 'q' to exit"
while True:
    key_pressed = raw_input("Enter button: ")
    if key_pressed == 'q':
        print "The end"
        break
    for button in Keyboard.keyboard:
        if button.key != key_pressed:
            print "Button doesn't exist"
            break
        else:
            keyboard.notice(button)
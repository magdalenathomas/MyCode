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

    def notice(self, proxy):
        proxy.check()
        self.unregister(proxy)


class AbstractButton:

    def __init__(self):
        pass

    def update(self):
        pass

    def check(self):
        pass


class Button(AbstractButton):

    def __init__(self, key):
        self.key = key

    def update(self):
        print "Button pushed: ", self.key


class Proxy(AbstractButton):

    def __init__(self, key):
        self.key = key

    def check(self):
        if key_pressed == 'w':
            klawisz = Button(key_pressed)
            klawisz.update()
        elif key_pressed == 'e':
            klawisz = Button(key_pressed)
            klawisz.update()
        elif key_pressed == 'r':
            klawisz = Button(key_pressed)
            klawisz.update()
        elif key_pressed == 't':
            klawisz = Button(key_pressed)
            klawisz.update()
        elif key_pressed == 'y':
            klawisz = Button(key_pressed)
            klawisz.update()
        elif key_pressed == 'u':
            klawisz = Button(key_pressed)
            klawisz.update()
        elif key_pressed == 'i':
            klawisz = Button(key_pressed)
            klawisz.update()
        elif key_pressed == 'o':
            klawisz = Button(key_pressed)
            klawisz.update()
        elif key_pressed == 'p':
            klawisz = Button(key_pressed)
            klawisz.update()


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

k1 = Proxy("a")
k2 = Proxy("w")
k3 = Proxy("r")
k4 = Button("d")
k5 = Button("e")
#k6 = DecoratedButton1(k1)
#k7 = DecoratedButton2(k2)


keyboard.register(k1)
keyboard.register(k2)
keyboard.register(k3)
keyboard.register(k4)
keyboard.register(k5)

print "Press 'q' to exit"
while True:
    key_pressed = raw_input("Enter button: ")
    if key_pressed == 'q':
        print "The end"
        break
    for proxy in Keyboard.keyboard:
        if proxy.key == key_pressed:
            keyboard.notice(proxy)
        elif proxy.key != key_pressed:
            print "Button doesn't exist"
            break

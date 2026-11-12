def wisefier(sentence):

    # lowercases the string
    lowered_sentence = sentence.lower()

    # entries of  words to search for in string
    acceptable = ["must", "are", "can", "will", "have"]

    # splits the words in the original sentence after every space into a list
    sentence_list = lowered_sentence.rsplit(" ")

    # attributing none to found first to trigger the if else condition below
    # to exit the func if no acceptable word was found
    found = None

    # first loop iterates through every element from original sentence list.
    # on each iteration, gets a element from it,
    # on second loop, compares that current element with each element from acceptable list,
    # exits when found the first acceptable word
    for ele in sentence_list:
        for i in range(len(acceptable)):
            if ele == acceptable[i]:
                found = acceptable[i]
                break

    # handles cases were no wise word is found.
    # it not none (as set above), attributes wise_word with the found word in original sentence.
    # else, returns that no wise word was found
    if found != None:
        wise_word = found
    else:
        return print("no wise word found")

    if wise_word:

        # index of the wise word found in list
        list_index = sentence_list.index(wise_word)

        # empty lists to iterate and append elements from sentence_list
        first_part = []
        second_part = []

        # first half of the wise sentence,
        # starts at the element after the wise word index from sentence_list,
        # appends all elements until end of sentence_list to empty first_part list
        for i in range(list_index + 1, len(sentence_list)):
            first_part.append(sentence_list[i])

        # second half of the wise sentence,
        # iterates from the first element(0) of sentence_list,
        # until the index of the wise_word element found in it
        for i in range(list_index + 1):
            second_part.append(sentence_list[i])

        # adding final comma to the end of the first part of the wise sentence
        first_part_last_ele = first_part[len(first_part) - 1]
        first_part[len(first_part) - 1] = first_part_last_ele + ","

        # building final list with the formatted wise sentence,
        # adds to the end of completed the first_part, then the second_part
        completed = []
        completed.extend(first_part)
        completed.extend(second_part)

        # joins a empty string with the elements of the completed (which are strings),
        # "creating" a new string
        result = " ".join(completed)

        return print(result)

wisefier("they must prepare for the future")

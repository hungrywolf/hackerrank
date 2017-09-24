#!/usr/bin/python

import sys, getopt, ConfigParser, subprocess, os
from datetime import date, timedelta

def run_cmd(args_list):
    print('Running system command: {0}'.format(' '.join(args_list)))
    proc = subprocess.Popen(args_list, stdout=subprocess.PIPE,
            stderr=subprocess.PIPE)
    (output, errors) = proc.communicate()
    if proc.returncode:
        raise RuntimeError(
            'Error running command: %s. Return code: %d, Error: %s' % (
                ' '.join(args_list), proc.returncode, errors))
    return (output, errors)

def main(configFilePath,days):
    day = date.today() - timedelta(days)
    config = ConfigParser.ConfigParser()
    config.read(configFilePath)

    tables = config.get('Feedstables','tables').split(",")
    datefomate = config.get('Settings','ProcessingDateFormat')

    feedsSQLFile = config.get('Settings','FeedsSQLFile')
    rejectionAndDedupSQLFile = config.get('Settings','RejectionAndDedupSQLFile')
    dropTablesSQLFile = config.get('Settings','DropTablesSQLFile')

    formatedDate = day.strftime(datefomate)

    rejectionAndDedupOutPut, rejectionAndDedupErrors = run_cmd(['hive', '-f',rejectionAndDedupSQLFile,'-hiveconf', 'date='+formatedDate])
    print (rejectionAndDedupOutPut)

    for table in tables:
        feedsOutPut, feedsErrors = run_cmd(['hive', '-f',feedsSQLFile,'-hiveconf', 'table='+table,'-hiveconf', 'date='+formatedDate])
        print (feedsOutPut)

    dropTablesOutPut, dropTablesErrors = run_cmd(['hive', '-f',dropTablesSQLFile,'-hiveconf', 'date='+formatedDate])
    print (dropTablesOutPut)


if __name__ == "__main__":
    if len(sys.argv) > 2:
        main(sys.argv[1],int(sys.argv[2]))
    else :
        print ("not enough paramters make sure to pass config path and number of days")

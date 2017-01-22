module.exports = function(grunt) {

    require('load-grunt-tasks')(grunt);

    grunt.initConfig({
        bower_concat: {
            all: {
                dest: 'src/main/resources/static/js/bower.js',
                cssDest: 'src/main/resources/static/css/bower.css'
            }
        },
        uglify: {
            build: {
                src: 'src/main/resources/static/js/bower.js',
                dest: 'src/main/resources/static/js/bower.min.js'
            }
        }
    });

    grunt.loadNpmTasks('grunt-bower-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');

    grunt.registerTask('build', [
        'bower_concat',
        'uglify'
    ])
};


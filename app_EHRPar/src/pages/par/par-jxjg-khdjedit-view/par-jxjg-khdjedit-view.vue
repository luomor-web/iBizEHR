<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParJxjgKHDJEditViewBase from './par-jxjg-khdjedit-view-base.vue';

import view_form from '@widgets/par-jxjg/jxdj-form/jxdj-form.vue';

/**
 * 绩效考核定级
 *
 * @export
 * @class ParJxjgKHDJEditView
 * @extends {ParJxjgKHDJEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ParJxjgKHDJEditView extends ParJxjgKHDJEditViewBase { }
</script>
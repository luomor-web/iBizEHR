<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParTzggEditView9Base from './par-tzgg-edit-view9-base.vue';

import view_form from '@widgets/par-tzgg/main2-form/main2-form.vue';

/**
 * 通知信息
 *
 * @export
 * @class ParTzggEditView9
 * @extends {ParTzggEditView9Base}
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
export default class ParTzggEditView9 extends ParTzggEditView9Base { }
</script>
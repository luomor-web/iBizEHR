<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParTzggEditViewBase from './par-tzgg-edit-view-base.vue';

import view_form from '@widgets/par-tzgg/main-form/main-form.vue';

/**
 * 通知信息
 *
 * @export
 * @class ParTzggEditView
 * @extends {ParTzggEditViewBase}
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
export default class ParTzggEditView extends ParTzggEditViewBase { }
</script>
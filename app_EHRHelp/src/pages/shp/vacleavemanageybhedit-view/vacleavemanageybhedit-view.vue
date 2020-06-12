<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEMANAGEYBHEditViewBase from './vacleavemanageybhedit-view-base.vue';

import view_form from '@widgets/vac-leave-manage/ybh-form/ybh-form.vue';

/**
 * 请假管理
 *
 * @export
 * @class VACLEAVEMANAGEYBHEditView
 * @extends {VACLEAVEMANAGEYBHEditViewBase}
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
export default class VACLEAVEMANAGEYBHEditView extends VACLEAVEMANAGEYBHEditViewBase { }
</script>
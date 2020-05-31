<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEMANAGEYTGEditViewBase from './vacleavemanageytgedit-view-base.vue';

import view_form from '@widgets/vac-leave-manage/ytg-form/ytg-form.vue';

/**
 * 请假管理
 *
 * @export
 * @class VACLEAVEMANAGEYTGEditView
 * @extends {VACLEAVEMANAGEYTGEditViewBase}
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
export default class VACLEAVEMANAGEYTGEditView extends VACLEAVEMANAGEYTGEditViewBase { }
</script>
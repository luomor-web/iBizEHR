<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEMANAGEYQXEditViewBase from './vacleavemanageyqxedit-view-base.vue';

import view_form from '@widgets/vac-leave-manage/yqx-form/yqx-form.vue';

/**
 * 请假管理
 *
 * @export
 * @class VACLEAVEMANAGEYQXEditView
 * @extends {VACLEAVEMANAGEYQXEditViewBase}
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
export default class VACLEAVEMANAGEYQXEditView extends VACLEAVEMANAGEYQXEditViewBase { }
</script>
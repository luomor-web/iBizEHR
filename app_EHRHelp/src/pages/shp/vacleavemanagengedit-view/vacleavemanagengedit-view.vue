<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEMANAGENGEditViewBase from './vacleavemanagengedit-view-base.vue';

import view_form from '@widgets/vacleavemanage/ng-form/ng-form.vue';

/**
 * 请假管理
 *
 * @export
 * @class VACLEAVEMANAGENGEditView
 * @extends {VACLEAVEMANAGENGEditViewBase}
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
export default class VACLEAVEMANAGENGEditView extends VACLEAVEMANAGENGEditViewBase { }
</script>
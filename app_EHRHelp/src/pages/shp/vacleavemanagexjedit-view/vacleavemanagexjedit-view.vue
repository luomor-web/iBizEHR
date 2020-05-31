<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEMANAGEXJEditViewBase from './vacleavemanagexjedit-view-base.vue';

import view_form from '@widgets/vac-leave-manage/xj-form/xj-form.vue';

/**
 * 销假
 *
 * @export
 * @class VACLEAVEMANAGEXJEditView
 * @extends {VACLEAVEMANAGEXJEditViewBase}
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
export default class VACLEAVEMANAGEXJEditView extends VACLEAVEMANAGEXJEditViewBase { }
</script>
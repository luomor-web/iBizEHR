<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILEFJEditViewBase from './pcmprofilefjedit-view-base.vue';

import view_form from '@widgets/pcmprofilefj/main-form/main-form.vue';

/**
 * 应聘者附件编辑视图
 *
 * @export
 * @class PCMPROFILEFJEditView
 * @extends {PCMPROFILEFJEditViewBase}
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
export default class PCMPROFILEFJEditView extends PCMPROFILEFJEditViewBase { }
</script>
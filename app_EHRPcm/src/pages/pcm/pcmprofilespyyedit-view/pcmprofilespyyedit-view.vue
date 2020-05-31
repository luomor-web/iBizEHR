<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMPROFILESPYYEditViewBase from './pcmprofilespyyedit-view-base.vue';

import view_form from '@widgets/pcm-profile-spyy/main-form/main-form.vue';

/**
 * 应聘者审批原因编辑视图
 *
 * @export
 * @class PCMPROFILESPYYEditView
 * @extends {PCMPROFILESPYYEditViewBase}
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
export default class PCMPROFILESPYYEditView extends PCMPROFILESPYYEditViewBase { }
</script>
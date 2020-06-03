<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxXZEditViewBase from './pcm-ydbxmx-xzedit-view-base.vue';

import view_form from '@widgets/pcm-ydbxmx/main-form/main-form.vue';

/**
 * 新增病休
 *
 * @export
 * @class PcmYdbxmxXZEditView
 * @extends {PcmYdbxmxXZEditViewBase}
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
export default class PcmYdbxmxXZEditView extends PcmYdbxmxXZEditViewBase { }
</script>
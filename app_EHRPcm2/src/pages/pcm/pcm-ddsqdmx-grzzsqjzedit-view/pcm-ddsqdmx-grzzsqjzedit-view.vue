<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmDdsqdmxGRZZSQJZEditViewBase from './pcm-ddsqdmx-grzzsqjzedit-view-base.vue';

import view_form from '@widgets/pcm-ddsqdmx/zzsqjzform-form/zzsqjzform-form.vue';

/**
 * 兼职申请编辑视图
 *
 * @export
 * @class PcmDdsqdmxGRZZSQJZEditView
 * @extends {PcmDdsqdmxGRZZSQJZEditViewBase}
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
export default class PcmDdsqdmxGRZZSQJZEditView extends PcmDdsqdmxGRZZSQJZEditViewBase { }
</script>
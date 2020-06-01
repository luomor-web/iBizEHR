/**
 * BMKQSZ 部件模型
 *
 * @export
 * @class BMKQSZModel
 */
export default class BMKQSZModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof BMKQSZModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'orgsectorid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'orgsectorname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'zzdzs',
        prop: 'zzdzs',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'orgsectorname',
        prop: 'orgsectorname',
        dataType: 'TEXT',
      },
      {
        name: 'orgsectorid',
        prop: 'orgsectorid',
        dataType: 'GUID',
      },
      {
        name: 'ormorgsector',
        prop: 'orgsectorid',
        dataType: 'FONTKEY',
      },
    ]
  }

}
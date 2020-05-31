/**
 * YTG 部件模型
 *
 * @export
 * @class YTGModel
 */
export default class YTGModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof YTGModel
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
        prop: 'vacleavemanageid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
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
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgsectorid',
        prop: 'ormorgsectorid',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'qjsy',
        prop: 'qjsy',
        dataType: 'TEXT',
      },
      {
        name: 'wfqqjstate',
        prop: 'wfqqjstate',
        dataType: 'SSCODELIST',
      },
      {
        name: 'vacleavemanageid',
        prop: 'vacleavemanageid',
        dataType: 'GUID',
      },
      {
        name: 'vacleavemanage',
        prop: 'vacleavemanageid',
        dataType: 'FONTKEY',
      },
    ]
  }

}
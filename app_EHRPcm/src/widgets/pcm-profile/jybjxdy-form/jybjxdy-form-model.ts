/**
 * JYBJXDY 部件模型
 *
 * @export
 * @class JYBJXDYModel
 */
export default class JYBJXDYModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof JYBJXDYModel
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
        prop: 'pcmprofileid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmprofilename',
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
        name: 'pcmprofileid',
        prop: 'pcmprofileid',
        dataType: 'GUID',
      },
      {
        name: 'pcmprofile',
        prop: 'pcmprofileid',
        dataType: 'FONTKEY',
      },
    ]
  }

}